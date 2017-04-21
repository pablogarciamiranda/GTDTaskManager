package uo.sdi.client.actions;

import java.util.List;

import alb.util.console.Console;
import alb.util.date.DateUtil;
import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.Category;
import uo.sdi.client.model.Task;
import uo.sdi.client.model.User;
import uo.sdi.client.service.AdminServicesRest;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.client.validation.Authenticator;
import uo.sdi.menu.Action;

public class AddTask implements Action {
	
	Authenticator userValidation = new Authenticator();

	@Override
	public void execute(UserServicesRest userServiceRest,
			AdminServicesRest adminServiceRest,
			TaskServicesRest taskServicesRest) throws BusinessException {
		
		User user = userValidation.validation(userServiceRest);
		if (user != null){
			Task task = new Task();
			
			String title = Console.readString("> Introduce a title for the task");
			task.setTitle(title);
			
			String comments = Console.readString("> Introduce a comment for the task");
			task.setComments(comments);
			
			task.setCreated(DateUtil.today());
			
			List<Category> categories = taskServicesRest.findCategoriesByUserId(user.getId());
			showCategories(categories);
			long category_id = Console.readLong("> Introduce the id of a category");
			task.setCategoryId(category_id);
			
			task.setUserId(user.getId());
		
			taskServicesRest.createTask(task);
		}
	}
	
	private void showCategories(List<Category> categories) {
		for (Category c: categories){
			System.out.println(c);
		}
	}

}