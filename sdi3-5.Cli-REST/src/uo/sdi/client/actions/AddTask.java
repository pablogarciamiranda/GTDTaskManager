package uo.sdi.client.actions;

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
import alb.util.date.*;

public class AddTask implements Action {

	@Override
	public void execute(UserServicesRest userServiceRest,
			TaskServicesRest taskServicesRest, RestClient client)
			throws BusinessException {
		try {
			User user = userServiceRest.findLoggableUser(client.getLogin());

			Task task = new Task();

			// Title of the task
			String title = Console
					.readString("> Introduce a title for the task");
			if (title == null || title.trim().isEmpty()) {
				System.out
						.println("That input is not valid. Please, try again");
				title = null;
				title = Console.readString("> Introduce a title for the task");
			}
			task.setTitle(title);

			// Comments of the task
			String comments = Console
					.readString("> Introduce a comment for the task");
			task.setComments(comments);

			// Category of the task
			Long categoryId = Console
					.readLong("> Introduce the id of a category or 0 to set no category");
			while (categoryId == null || categoryId < 0) {
				System.out
						.println("That input is not valid. Please, try again");
				categoryId = null;
				categoryId = Console
						.readLong("> Introduce the id of a category or 0 to set no category");
			}
			if (categoryId == 0)
				categoryId = null;
			else {
				Category category = taskServicesRest
						.findCategoryById(categoryId);
				if (category == null)
					throw new BusinessException("There is no category with id "
							+ categoryId);
			}
			task.setCategoryId(categoryId);

			// Owner of the task
			task.setUserId(user.getId());
			
			//Planned date
			String response = "";
			do {
				response = Console
						.readString("> Do you want a planned date? (y/n)");

			} while (!response.equals("yes") && !response.equals("no")
					&& !response.equals("y") && !response.equals("n"));

			String date = "";
			do {
				System.out.println("> Please, introduce a valid date");
				if (response.equals("yes") || response.equals("y")) {
					String day = Console.readString("\t> Introduce a valid day (dd)");
					String month = Console
							.readString("\t> Introduce a valid month (mm)");
					String year = Console
							.readString("\t> Introduce a valid year (yyyy)");
					date = day + "/" + month + "/" + year;

				}
			} while (!FreijeyPabloUtil.isDateValid(date));
			
			if (response.equals("yes") || response.equals("y")){
				task.setPlanned(DateUtil.fromString(date));
			}
			

			taskServicesRest.createTask(task);
			System.out.println("The task '" + task.getTitle()
					+ "' has been created.");

		} catch (BusinessException b) {
			System.out.println("The task can not be created due to: \n\t"
					+ b.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("There was a problem with the system");
		}
	}
}
