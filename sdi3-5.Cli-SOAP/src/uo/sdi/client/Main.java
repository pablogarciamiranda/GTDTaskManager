package uo.sdi.client;

import java.util.List;

import com.sdi.uo.AdminService;
import com.sdi.uo.EJBAdminServiceService;
import com.sdi.uo.User;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	private void run() throws Exception {
		AdminService service = new EJBAdminServiceService()
				.getAdminServicePort();
		List<User> users = service.findAllUsers();
		printHeader();
		for (User u : users) {
			printLine(u);
		}
	}

	private void printHeader() {
		System.out.printf("%s %s %s %s\n", "_ID__", "_LOGIN_________",
				"_PASSWORD___________", "_EMAIL___________");
	}

	private void printLine(User u) {
		System.out.printf("%-20s %-15s %-25s %-8s\n", u.getId(), u.getLogin(),
				u.getPassword(), u.getEmail());
	}

}
