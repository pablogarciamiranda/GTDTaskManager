package uo.sdi.business;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

public interface UserService {

	public Long registerUser(User user) throws BusinessException;
	public void updateUserDetails(User user) throws BusinessException;
	User findLoggableUser(String login) throws BusinessException;

}
