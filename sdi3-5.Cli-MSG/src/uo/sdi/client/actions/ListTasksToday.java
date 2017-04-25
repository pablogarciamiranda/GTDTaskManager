package uo.sdi.client.actions;

import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import uo.sdi.client.model.Task;
import uo.sdi.client.model.User;
import uo.sdi.client.validation.Authenticator;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListTasksToday implements Action {
	private static final String REST_TASK_SERVICE_URL = "http://localhost:8280"
			+ "/sdi3-5.Web/rest/TaskServiceRs";

	private static final String REST_USER_SERVICE_URL = "http://localhost:8280"
			+ "/sdi3-5.Web/rest/UserServiceRs";

	private User user;

	@Override
	public void execute() throws Exception {
		if (!authentication())
			return;
		List<Task> tasks = getListTasksToday();
		
		if (tasks == null){
			System.out.println("There are not tasks finished for today");
		}
		showTasks(tasks);

	}

	private void showTasks(List<Task> tasks) {
		for (Task task : tasks){
			System.out.println(task);
		}
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

	private List<Task> getListTasksToday() {
		GenericType<List<Task>> listt = new GenericType<List<Task>>() {
		};
		try {
			List<Task> list = ClientBuilder
					.newClient()
					.register(
							new Authenticator(user.getLogin(), user
									.getPassword()))
					.target(REST_TASK_SERVICE_URL)
					.path("tasks/finished/today/user/" + user.getId())
					.request().get().readEntity(listt);

			return list;
		} catch (ProcessingException e) {
			return null;
		}
	}
}
