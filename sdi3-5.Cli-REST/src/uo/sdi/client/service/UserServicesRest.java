package uo.sdi.client.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.User;

@Path("/UserServiceRs")
public interface UserServicesRest {

	@GET
	@Path("user/{login}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findLoggableUser(@PathParam("login") String login)
			throws BusinessException;

}
