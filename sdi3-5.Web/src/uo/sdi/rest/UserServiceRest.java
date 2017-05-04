package uo.sdi.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

@Path("/UserServiceRs")
public interface UserServiceRest {

	@GET
	@Path("user/{login}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findLoggableUser(@PathParam("login") String login)
			throws BusinessException;

}
