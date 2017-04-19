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

@Path("/TaskServiceRs")
public interface TaskServiceRest {

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Long createCategory(Category category) throws BusinessException;

	@PUT
	@Path("{id}")
	public Long duplicateCategory(@PathParam("id") Long id)
			throws BusinessException;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateCategory(Category category) throws BusinessException;

	@DELETE
	@Path("{id}")
	public void deleteCategory(@PathParam("id") Long id) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public Category findCategoryById(@PathParam("id") Long id) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public List<Category> findCategoriesByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Long createTask(Task task) throws BusinessException;
	
	@DELETE
	@Path("{id}")
	public void deleteTask(@PathParam("id") Long id) throws BusinessException;

	@POST
	@Path("{id}")
	public void markTaskAsFinished(@PathParam("id") Long id) throws BusinessException;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateTask(Task task) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public Task findTaskById(@PathParam("id")  Long id) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public List<Task> findInboxTasksByUserId(@PathParam("id")  Long id) throws BusinessException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public List<Task> findWeekTasksByUserId(@PathParam("id")  Long id) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public List<Task> findTodayTasksByUserId(@PathParam("id")  Long id) throws BusinessException;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public List<Task> findTasksByCategoryId(@PathParam("id") Long catId)
			throws BusinessException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public List<Task> findFinishedTasksByCategoryId(@PathParam("id") Long catId)
			throws BusinessException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public List<Task> findFinishedInboxTasksByUserId(@PathParam("id") Long userId)
			throws BusinessException;

}
