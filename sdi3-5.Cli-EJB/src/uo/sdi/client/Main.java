package uo.sdi.client;

import java.util.List;

import uo.sdi.business.AdminService;
import uo.sdi.business.impl.RemoteEJBServicesLocator;
import uo.sdi.dto.UserInfo;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	private static final String USER_SERVICE_JNDI_KEY = "java:app" + "sdi3-5/"
			+ "sdi3-5.EJB/" + "EJBUserService!"
			+ "uo.sdi.business.impl.user.LocalUserService";

	private static final String ADMIN_SERVICE_JNDI_KEY = "java:app" + "sdi3-5/"
			+ "sdi3-5.EJB/" + "EJBAdminService!"
			+ "uo.sdi.business.impl.admin.LocalAdminService";

	private static final String TASK_SERVICE_JNDI_KEY = "java:app" + "sdi3-5/"
			+ "sdi3-5.EJB/" + "EJBTaskService!"
			+ "uo.sdi.business.impl.task.LocalTaskService";

	private void run() throws Exception {
		AdminService service = new RemoteEJBServicesLocator().getAdminService();
		List<UserInfo> users = service.findAllUsersInfo();
		printHeader();
		for (UserInfo u : users) {
			printLine(u);
		}
	}

	private void printHeader() {
		System.out.printf("%s %s\n", "_ID__", "_LOGIN_________");
	}

	private void printLine(UserInfo u) {
		System.out.printf("%-20s %-15s", u.getId(), u.getLogin());
	}

}
