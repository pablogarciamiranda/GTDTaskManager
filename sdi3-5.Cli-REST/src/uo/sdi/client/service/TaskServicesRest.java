package uo.sdi.client.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.Category;
import uo.sdi.client.model.Task;

@Path("/TaskServiceRs")
public interface TaskServicesRest {

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("categories/user/{id}")
	public List<Category> findCategoriesByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("categories/{id}")
	public Category findCategoryById(@PathParam("id") Long id)
			throws BusinessException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("tasks/category/{id}")
	public List<Task> findTasksByCategoryId(@PathParam("id") Long catId)
			throws BusinessException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("tasks/user/{id}")
	public Task findTaskById(@PathParam("id")  Long id) throws BusinessException;

	@POST
	@Path("tasks/finish/{id}/")
	public void markTaskAsFinished(@PathParam("id") Long id) throws BusinessException;
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks")
	public Response createTask(Task task) throws BusinessException;

}
