package uo.sdi.rest;

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

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;

@Path("/TaskServiceRs")
public interface TaskServiceRest {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("categories/{id}")
	public Category findCategoryById(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("categories/userR/{id}")
	public Response findCategoriesByUserIdR(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("categories/user/{id}")
	public List<Category> findCategoriesByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("tasks")
	public Response createTask(Task task) throws BusinessException;

	@POST
	@Path("tasks/finish/{id}")
	public Response markTaskAsFinished(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/user/{id}")
	public Task findTaskById(@PathParam("id") Long id) throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/category/{id}")
	public List<Task> findTasksByCategoryId(@PathParam("id") Long catId)
			throws BusinessException;
}
