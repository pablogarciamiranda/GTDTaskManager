package uo.sdi.rest;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import uo.sdi.business.AdminService;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.infraestructure.Factories;

@Path("/AdminServiceRs")
public class AdminServiceRestImpl implements AdminServiceRest {

	AdminService service = Factories.services.getAdminService();

	@Override
	public Response findAllUsersR() throws BusinessException {
		List<User> users = service.findAllUsers();

		return Response
				.ok()
				.entity(users)
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT")
				.header("Access-Control-Allow-Headers", "Authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.allow("OPTIONS").build();
	}

}
