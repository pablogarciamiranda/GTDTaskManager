package uo.sdi.client.validation;

import alb.util.console.Console;
import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.User;
import uo.sdi.client.service.UserServicesRest;

public class Authenticator {

	public User validation(UserServicesRest userService) {
		String login = Console.readString("> Introduce your name: ");
		String password = Console.readString("> Introduce your password");

		User user = null;
		try {
			user = userService.findLoggableUser(login);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
		if (user == null) {
			System.out
					.println("There is not an user registered with that login, try again");
			return null;
		}
		if (!user.getPassword().equals(password)) {
			System.out.println("The password is incorrect, try again");
			return null;
		}
		return user;

	}

}
