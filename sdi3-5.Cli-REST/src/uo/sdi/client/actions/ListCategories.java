package uo.sdi.client.actions;

import java.util.List;

import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.Category;
import uo.sdi.client.model.User;
import uo.sdi.client.service.AdminServicesRest;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.client.validation.Authenticator;
import uo.sdi.menu.Action;

public class ListCategories implements Action {
	
	Authenticator userValidation = new Authenticator();

	@Override
	public void execute(UserServicesRest userServiceRest,
			AdminServicesRest adminServiceRest,
			TaskServicesRest taskServicesRest) throws BusinessException {
		
		User user = userValidation.validation(userServiceRest);
		if (user != null){
			List<Category> categories = taskServicesRest.findCategoriesByUserId(user.getId());
			showCategories(categories);
		}
	}

	private void showCategories(List<Category> categories) {
		for (Category c: categories){
			System.out.println(c);
		}
	}

}
