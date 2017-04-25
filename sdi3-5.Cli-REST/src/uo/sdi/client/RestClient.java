package uo.sdi.client;

import javax.ws.rs.NotAuthorizedException;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.User;
import uo.sdi.client.service.AdminServicesRest;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.client.validation.Authenticator;
import alb.util.console.Console;

public class RestClient {

	private UserServicesRest userService;
	private AdminServicesRest adminService;
	private TaskServicesRest taskService;
	private String login;

	public RestClient() {
		login();
	}

	private void login() {
		String login = Console.readString("> Introduce your name: ");
		String password = Console.readString("> Introduce your password");

		userService = new ResteasyClientBuilder().build()
				.register(new Authenticator(login, password))
				.target("http://localhost:8280/sdi3-5.Web/rest/")
				.proxy(UserServicesRest.class);

		taskService = new ResteasyClientBuilder().build()
				.register(new Authenticator(login, password))
				.target("http://localhost:8280/sdi3-5.Web/rest/")
				.proxy(TaskServicesRest.class);

		User user = null;
		try {
			user = userService.findLoggableUser(login);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			login();
		} catch (NotAuthorizedException e) {
			System.out.println("Incorrect login, try again");
			login();
		} catch (Exception e) {
			System.out.println("Something happen, try again");
			login();
		}
		if (user != null) {
			System.out
					.println("Welcome to the REST client developed by Pablo García Miranda & Fernando Freije Fuente!");
			this.login = login;
		}
	}

	public UserServicesRest getUserService() {
		return userService;
	}

	public AdminServicesRest getAdminService() {
		return adminService;
	}

	public TaskServicesRest getTaskService() {
		return taskService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
