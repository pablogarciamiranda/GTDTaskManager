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
import javax.ws.rs.core.Response;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;

@Path("/TaskServiceRs")
public interface TaskServiceRest {

	@PUT
	@Path("categories")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Long createCategory(Category category) throws BusinessException;

	@PUT
	@Path("categories/duplicate/{id}")
	public Long duplicateCategory(@PathParam("id") Long id)
			throws BusinessException;

	@POST
	@Path("categories")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateCategory(Category category) throws BusinessException;

	@DELETE
	@Path("categories/{id}/delete")
	public void deleteCategory(@PathParam("id") Long id)
			throws BusinessException;

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
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("categories/user/{id}")
	public List<Category> findCategoriesByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("tasks")
	public Response createTask(Task task) throws BusinessException;

	@DELETE
	@Path("tasks/delete/{id}")
	public void deleteTask(@PathParam("id") Long id) throws BusinessException;

	@POST
	@Path("tasks/finish/{id}")
	public Response markTaskAsFinished(@PathParam("id") Long id)
			throws BusinessException;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks")
	public void updateTask(Task task) throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/user/{id}")
	public Task findTaskById(@PathParam("id") Long id) throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/inbox/user/{id}")
	public List<Task> findInboxTasksByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/week/user/{id}")
	public List<Task> findWeekTasksByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/today/user/{id}")
	public List<Task> findTodayTasksByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("tasks/categoryR/{id}")
	public Response findTasksByCategoryIdR(@PathParam("id") Long catId)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/category/{id}")
	public List<Task> findTasksByCategoryId(@PathParam("id") Long catId)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/finished/category/{id}")
	public List<Task> findFinishedTasksByCategoryId(@PathParam("id") Long catId)
			throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("tasks/finished/inbox/category/{id}")
	public List<Task> findFinishedInboxTasksByUserId(
			@PathParam("id") Long userId) throws BusinessException;

}
