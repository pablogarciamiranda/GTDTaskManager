package uo.sdi.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

@Path("/AdminServiceRs")
public interface AdminServiceRest {
	
	@DELETE
	@Path("users/delete/{id}")
	public void deepDeleteUser(@PathParam("id") Long id) throws BusinessException;
	
	@POST
	@Path("users/disable/{id}")
	public void disableUser(@PathParam("id") Long id) throws BusinessException;
	
	@POST
	@Path("users/enable/{id}")
	public void enableUser(@PathParam("id") Long id) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("users")
	public List<User> findAllUsers() throws BusinessException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("users/{id}")
	public User findUserById(@PathParam("id")Long id) throws BusinessException;
	
	@POST
	@Path("admin/reset")
	public void resetDB() throws BusinessException;

}
