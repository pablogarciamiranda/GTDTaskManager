package uo.sdi.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uo.sdi.business.exception.BusinessException;

@Path("/AdminServiceRs")
public interface AdminServiceRest {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("usersR")
	public Response findAllUsersR() throws BusinessException;
}