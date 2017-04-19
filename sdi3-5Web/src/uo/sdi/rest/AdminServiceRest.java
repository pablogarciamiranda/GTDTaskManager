package uo.sdi.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

@Path("/AlumnosServiceRs")
public interface AdminServiceRest {
	
	@DELETE
	@Path("{id}")
	public void deepDeleteUser(@PathParam("id") Long id) throws BusinessException;
	
	@POST
	@Path("{id}")
	public void disableUser(@PathParam("id") Long id) throws BusinessException;
	
	@POST
	@Path("{id}")
	public void enableUser(@PathParam("id") Long id) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<User> findAllUsers() throws BusinessException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public User findUserById(@PathParam("id")Long id) throws BusinessException;
	
	@POST
	public void resetDB() throws BusinessException;

}
