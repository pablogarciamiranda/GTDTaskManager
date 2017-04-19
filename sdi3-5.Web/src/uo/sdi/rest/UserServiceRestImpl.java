package uo.sdi.rest;

import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.infraestructure.Factories;

public class UserServiceRestImpl implements UserServiceRest{
	
	UserService service = Factories.services.getUserService();
	
	@Override
	public Long registerUser(User user) throws BusinessException {
		return service.registerUser(user);
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		service.updateUserDetails(user);
	}

	@Override
	public User findLoggableUser(String login) throws BusinessException {
		return service.findLoggableUser(login);
	}

}
