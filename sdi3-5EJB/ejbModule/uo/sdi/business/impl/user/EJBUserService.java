package uo.sdi.business.impl.user;

import javax.ejb.Stateless;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.command.CommandExecutor;
import uo.sdi.business.impl.user.command.FindByLoginAndPasswordCommand;
import uo.sdi.business.impl.user.command.FindByLoginCommand;
import uo.sdi.business.impl.user.command.RegisterUserCommand;
import uo.sdi.business.impl.user.command.UpdateUserDetailsCommand;
import uo.sdi.dto.User;

/**
 * Session Bean implementation class EJBUserService
 */
@Stateless
public class EJBUserService implements RemoteUserService,
		LocalUserService {

	/**
	 * Default constructor.
	 */
	public EJBUserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long registerUser(User user) throws BusinessException {
		return new CommandExecutor<Long>()
				.execute(new RegisterUserCommand(user));
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		new CommandExecutor<Void>().execute(new UpdateUserDetailsCommand(user));
	}

	@Override
	public User findLoggableUser(final String login, final String password)
			throws BusinessException {

		return new CommandExecutor<User>()
				.execute(new FindByLoginAndPasswordCommand<User>(login,
						password));
	}

	@Override
	public User findLoggableUser(final String login) throws BusinessException {

		return new CommandExecutor<User>()
				.execute(new FindByLoginCommand<User>(login));
	}

}
