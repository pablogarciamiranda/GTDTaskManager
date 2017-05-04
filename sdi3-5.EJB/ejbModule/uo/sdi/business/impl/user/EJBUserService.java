package uo.sdi.business.impl.user;

import javax.ejb.Stateless;
import javax.jws.WebService;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.user.command.FindByLoginCommand;
import uo.sdi.business.impl.user.command.RegisterUserCommand;
import uo.sdi.business.impl.user.command.UpdateUserDetailsCommand;
import uo.sdi.dto.User;

/**
 * Session Bean implementation class EJBUserService
 */
@Stateless
@WebService(name = "UserService")
public class EJBUserService implements RemoteUserService, LocalUserService {

	/**
	 * Default constructor.
	 */
	public EJBUserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long registerUser(User user) throws BusinessException {
		return new RegisterUserCommand(user).execute();
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		new UpdateUserDetailsCommand(user).execute();
	}

	@Override
	public User findLoggableUser(final String login) throws BusinessException {
		return new FindByLoginCommand<User>(login).execute();
	}

}
