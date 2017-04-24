package uo.sdi.rest;

import java.util.List;

import javax.ws.rs.core.Response;

import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.infraestructure.Factories;

public class TaskServiceRestImpl implements TaskServiceRest {

	TaskService service = Factories.services.getTaskService();

	@Override
	public Long createCategory(Category category) throws BusinessException {
		return service.createCategory(category);
	}

	@Override
	public Long duplicateCategory(Long id) throws BusinessException {
		return service.duplicateCategory(id);
	}

	@Override
	public void updateCategory(Category category) throws BusinessException {
		service.updateCategory(category);
	}

	@Override
	public void deleteCategory(Long id) throws BusinessException {
		service.deleteCategory(id);
	}

	@Override
	public Category findCategoryById(Long id) throws BusinessException {
		return service.findCategoryById(id);
	}

	@Override
	public Response findCategoriesByUserIdR(Long id) throws BusinessException {

		List<Category> categories = service.findCategoriesByUserId(id);

		return Response
				.ok()
				// 200
				.entity(categories)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@Override
	public Response createTask(Task task) throws BusinessException {
		service.createTask(task);
		return Response.ok().header("Access-Control-Allow-Origin", "*").
				header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").
				header("Access-Control-Allow-Credentials", "true").
				header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").
				header("Access-Control-Allow-Headers", "Content-Type").
				header("Access-Control-Max-Age", "1209600")
				.build();
	}

	@Override
	public void deleteTask(Long id) throws BusinessException {
		service.deleteTask(id);
	}

	@Override
	public Response markTaskAsFinished(final Long id) throws BusinessException {
		service.markTaskAsFinished(id);
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public void updateTask(Task task) throws BusinessException {
		service.updateTask(task);
	}

	@Override
	public Task findTaskById(Long id) throws BusinessException {
		return service.findTaskById(id);
	}

	@Override
	public List<Task> findInboxTasksByUserId(Long id) throws BusinessException {
		return service.findInboxTasksByUserId(id);
	}

	@Override
	public List<Task> findWeekTasksByUserId(Long id) throws BusinessException {
		return service.findWeekTasksByUserId(id);
	}

	@Override
	public List<Task> findTodayTasksByUserId(Long id) throws BusinessException {
		return service.findTodayTasksByUserId(id);
	}

	@Override
	public Response findTasksByCategoryIdR(Long catId) throws BusinessException {
		List<Task> tasks = service.findTasksByCategoryId(catId);
		return Response
				.ok()
				// 200
				.entity(tasks)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@Override
	public List<Task> findFinishedTasksByCategoryId(Long catId)
			throws BusinessException {
		return service.findFinishedTasksByCategoryId(catId);
	}

	@Override
	public List<Task> findFinishedInboxTasksByUserId(Long userId)
			throws BusinessException {
		return service.findFinishedInboxTasksByUserId(userId);
	}

	@Override
	public List<Category> findCategoriesByUserId(Long id) throws BusinessException {
		return service.findCategoriesByUserId(id);	
	}

	@Override
	public List<Task> findTasksByCategoryId(Long catId) throws BusinessException {
		return service.findTasksByCategoryId(catId);
	}

}
