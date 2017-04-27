package uo.sdi.client.actions;

import java.util.Date;
import java.util.List;

import uo.sdi.client.RestClient;
import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.Category;
import uo.sdi.client.model.Task;
import uo.sdi.client.model.User;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.menu.Action;
import uo.sdi.util.FreijeyPabloUtil;
import alb.util.console.Console;

public class ListTasks implements Action {

	public void execute(UserServicesRest userServiceRest,
			TaskServicesRest taskServicesRest, RestClient client)
			throws BusinessException {
		try {
			// Show categories
			User user = userServiceRest.findLoggableUser(client.getLogin());

			List<Category> categories = taskServicesRest
					.findCategoriesByUserId(user.getId());

			showCategories(categories);

			// Choose a categoryId
			Long categoryId = Console.readLong("> Choose a category id");
			while (categoryId == null || categoryId < 0) {
				System.out
						.println("That input is not valid. Please, try again");
				categoryId = null;
				categoryId = Console.readLong("> Choose a category id");
			}

			Category category = taskServicesRest.findCategoryById(categoryId);
			if (category == null)
				throw new BusinessException("There is no category with id "
						+ categoryId);

			// Show tasks
			List<Task> tasks = taskServicesRest
					.findTasksByCategoryId(categoryId);
			showTasks(tasks);

		} catch (BusinessException b) {
			System.out.println("The tasks can not be shown due to: \n\t"
					+ b.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("There was a problem with the system");
		}

	}

	private void showTasks(List<Task> tasks) {
		printHeaderTasks();
		FreijeyPabloUtil.orderDescending(tasks);
		for (Task t : tasks) {
			printLineTask(t);
		}
	}

	private void showCategories(List<Category> categories) {
		printHeaderCategories();
		for (Category c : categories) {
			printLineCategory(c);
		}
	}

	private void printHeaderTasks() {
		System.out.printf("%s %s %s %s %s %s \n", "_ID_", "_CATEGORY_ID",
				"_NAME____________________________________",
				"_CREATED_____________________",
				"_PLANNED_____________________",
				"_FINISHED_____________________");
	}

	private void printHeaderCategories() {
		System.out.printf("%s %s \n", "_ID_", "_NAME______");
	}

	private void printLineTask(Task t) {
		String finished; 
		if (t.getFinished() == null)
			finished = "";
		else
			finished = t.getFinished().toString();
		String planned;
		if (t.getPlanned() == null)
			planned = "";
		else
			planned = t.getPlanned().toString();
		String created ;
		if (t.getCreated() == null)
			created = "";
		else
			created = t.getCreated().toString();

		System.out.printf("%-10s %-8s %-18s %-30s %-30s %-30s\n", t.getId(),
				t.getCategoryId(), t.getTitle(), created,
				planned, finished);
	}

	private void printLineCategory(Category c) {
		System.out.printf("%-5s %-8s\n", c.getId(), c.getName());
	}

}
