package uo.sdi.rest;

import java.util.List;

import uo.sdi.business.AdminService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.infraestructure.Factories;

public class AdminServiceRestImpl implements AdminServiceRest{

	AdminService service = Factories.services.getAdminService();
	
	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		service.deepDeleteUser(id);
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		service.disableUser(id);
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		service.enableUser(id);
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		return service.findAllUsers();
	}

	@Override
	public User findUserById(Long id) throws BusinessException {
		return service.findUserById(id);
	}

	@Override
	public void resetDB() throws BusinessException {
		service.resetDB();
	}

}
