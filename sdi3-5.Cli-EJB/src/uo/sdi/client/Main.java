package uo.sdi.client;

import java.util.List;

import uo.sdi.business.AdminService;
import uo.sdi.business.impl.RemoteEJBServicesLocator;
import uo.sdi.dto.User;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	private static final String USER_SERVICE_JNDI_KEY = "java:app" + "sdi3-5/"
			+ "sdi3-5EJB/" + "EJBUserService!"
			+ "uo.sdi.business.impl.user.LocalUserService";

	private static final String ADMIN_SERVICE_JNDI_KEY = "java:app" + "sdi3-5/"
			+ "sdi3-5EJB/" + "EJBAdminService!"
			+ "uo.sdi.business.impl.admin.LocalAdminService";

	private static final String TASK_SERVICE_JNDI_KEY = "java:app" + "sdi3-5/"
			+ "sdi3-5EJB/" + "EJBTaskService!"
			+ "uo.sdi.business.impl.task.LocalTaskService";

	private void run() throws Exception {
		AdminService service = new RemoteEJBServicesLocator().getAdminService();
		List<User> users = service.findAllUsers();
		printHeader();
		for (User u : users) {
			printLine(u);
		}
	}

	private void printHeader() {
		System.out.printf("%s %s %s %s\n", "_ID__", "_LOGIN_________",
				"_PASSWORD___________", "_EMAIL___________", "_IS_ADMIN____");
	}

	private void printLine(User u) {
		System.out.printf("%-20s %-15s %-25s %-8s\n", u.getId(), u.getLogin(),
				u.getPassword(), u.getEmail(), u.getIsAdmin());
	}

}
