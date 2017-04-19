package uo.sdi.business.impl.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.admin.command.DeepDeleteUserCommand;
import uo.sdi.business.impl.admin.command.DisableUserCommand;
import uo.sdi.business.impl.admin.command.EnableUserCommand;
import uo.sdi.business.impl.admin.command.ResetDBCommand;
import uo.sdi.business.impl.command.Command;
import uo.sdi.business.impl.command.CommandExecutor;
import uo.sdi.dto.User;
import uo.sdi.infraestructure.Factories;

/**
 * Session Bean implementation class EJBAdminService
 */
@Stateless
@WebService(name="AdminService")
public class EJBAdminService implements RemoteAdminService,
		LocalAdminService {

	/**
	 * Default constructor.
	 */
	public EJBAdminService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		new CommandExecutor<Void>().execute(new DeepDeleteUserCommand(id));
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		new CommandExecutor<Void>().execute(new DisableUserCommand(id));
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		new CommandExecutor<Void>().execute(new EnableUserCommand(id));
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		return new CommandExecutor<List<User>>()
				.execute(new Command<List<User>>() {
					@Override
					public List<User> execute() throws BusinessException {

						return Factories.persistence.getUserDao().findAll();
					}
				});
	}

	@Override
	public User findUserById(final Long id) throws BusinessException {
		return new CommandExecutor<User>().execute(new Command<User>() {
			@Override
			public User execute() throws BusinessException {
				return Factories.persistence.getUserDao().findById(id);
			}
		});
	}

	@Override
	public void resetDB() throws BusinessException {
		new CommandExecutor<Void>().execute(new ResetDBCommand());

	}
}
