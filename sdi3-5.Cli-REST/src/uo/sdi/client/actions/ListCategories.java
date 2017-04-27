package uo.sdi.client.actions;

import java.util.List;

import uo.sdi.client.RestClient;
import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.Category;
import uo.sdi.client.model.User;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.menu.Action;

public class ListCategories implements Action {

	public void execute(UserServicesRest userServiceRest,
			TaskServicesRest taskServicesRest, RestClient client)
			throws BusinessException {

		try {
			// Get id of the user
			User user = userServiceRest.findLoggableUser(client.getLogin());

			// Show the categories of the user
			List<Category> categories = taskServicesRest
					.findCategoriesByUserId(user.getId());
			showCategories(categories);

		} catch (Exception e) {
			System.out.println("There was a problem with the system");
		}
	}

	private void showCategories(List<Category> categories) {
		printHeaderCategories();
		for (Category c : categories) {
			printLineCategory(c);
		}
	}

	private void printHeaderCategories() {
		System.out.printf("%s %s \n", "_ID_", "_NAME______");
	}
	
	private void printLineCategory(Category c) {
		System.out.printf("%-5s %-8s\n", c.getId(), c.getName());
	}
}
