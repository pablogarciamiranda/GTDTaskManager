package uo.sdi.client.actions;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import uo.sdi.client.model.User;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.client.validation.Authenticator;
import uo.sdi.menu.Action;
import alb.util.console.Console;

public class FinishTask implements Action {

	private static final String REST_TASK_SERVICE_URL = "http://localhost:8280"
			+ "/sdi3-5.Web/rest/TaskServiceRs";

	private static final String REST_USER_SERVICE_URL = "http://localhost:8280"
			+ "/sdi3-5.Web/rest/UserServiceRs";

	private User user;

	@Override
	public void execute(UserServicesRest userServiceRest,
			TaskServicesRest taskServicesRest) {
		if (!authentication())
			return;
		String login = Console.readString("> Introduce the ID of the task you want to finish: ");

	}

	private boolean authentication() {
		String login = Console.readString("> Introduce your login: ");
		String password = Console.readString("> Introduce your password: ");

		User user = getUserByLogin(login, password);
		if (user == null) {
			System.out.println("The user does not exist, try again.");
			return false;
		}
		if (!user.getPassword().equals(password)) {
			System.out.println("The passwords do not match, try again.");
			return false;
		}
		this.user = user;
		return true;
	}

	private User getUserByLogin(String login, String password) {
		try {
			return (User) ClientBuilder.newClient()
					.register(new Authenticator(login, password))
					.target(REST_USER_SERVICE_URL).path("user/" + login)
					.request().accept(MediaType.APPLICATION_XML).get()
					.readEntity(User.class);
		} catch (ProcessingException e) {
			return null;
		}
	}

}
