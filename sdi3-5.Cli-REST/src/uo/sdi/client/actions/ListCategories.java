package uo.sdi.client.actions;

import java.util.List;

import uo.sdi.client.RestClient;
import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.Category;
import uo.sdi.client.model.User;
import uo.sdi.client.service.AdminServicesRest;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.menu.Action;

public class ListCategories implements Action {

	@Override
	public void execute(UserServicesRest userServiceRest,
			AdminServicesRest adminServiceRest,
			TaskServicesRest taskServicesRest) throws BusinessException {

		RestClient client = new RestClient();
		User user = userServiceRest.findLoggableUser(client.getLogin());

		if (user != null) {
			List<Category> categories = taskServicesRest
					.findCategoriesByUserId(user.getId());
			showCategories(categories);
		}
	}

	private void showCategories(List<Category> categories) {
		for (Category c : categories) {
			System.out.println(c);
		}
	}

}
