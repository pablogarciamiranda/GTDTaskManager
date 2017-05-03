package uo.sdi.business.impl.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.admin.command.DeepDeleteUserCommand;
import uo.sdi.business.impl.admin.command.DisableUserCommand;
import uo.sdi.business.impl.admin.command.EnableUserCommand;
import uo.sdi.business.impl.admin.command.ResetDBCommand;
import uo.sdi.dto.User;
import uo.sdi.dto.UserInfo;
import uo.sdi.infraestructure.Factories;

/**
 * Session Bean implementation class EJBAdminService
 */
@Stateless
@WebService(name = "AdminService")
public class EJBAdminService implements RemoteAdminService, LocalAdminService {

	/**
	 * Default constructor.
	 */
	public EJBAdminService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		new DeepDeleteUserCommand(id).execute();
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		new DisableUserCommand(id).execute();
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		new EnableUserCommand(id).execute();
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		return Factories.persistence.getUserDao().findAll();

	}

	@Override
	public List<UserInfo> findAllUsersInfo() throws BusinessException {
		return Factories.persistence.getUserDao().findAllInfo();
	}

	@Override
	public User findUserById(final Long id) throws BusinessException {
		return Factories.persistence.getUserDao().findById(id);
	}

	@Override
	public void resetDB() throws BusinessException {
		new ResetDBCommand().execute();

	}
}
