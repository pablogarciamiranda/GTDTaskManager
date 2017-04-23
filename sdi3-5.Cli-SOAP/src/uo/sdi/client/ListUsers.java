package uo.sdi.client;

import java.util.List;

import alb.util.menu.Action;

import com.sdi.uo.AdminService;
import com.sdi.uo.EJBAdminServiceService;
import com.sdi.uo.UserInfo;

public class ListUsers implements Action {

	@Override
	public void execute() throws Exception {
		AdminService service = new EJBAdminServiceService().getAdminServicePort();
		List<UserInfo> users = service.findAllUsersInfo();
		printHeader();
		for (UserInfo u : users) {
			printLine(u);
		}
	}

	private void printHeader() {
		System.out.printf("%s %s %s %s %s %s %s %s %s\n", "_ID__", "_LOGIN_________",
				"_PASSWORD___________", "_EMAIL___________", "_Tasks Finished___________",
				"_Tasks Finished Late___________","_Tasks Planned___________", "_Tasks Unplanned___________");
	}

	private void printLine(UserInfo u) {
		System.out.printf("%-20s %-15s %-25s %-8s %d %d %d %d\n", u.getId(), u.getLogin(),
				u.getEmail(), u.getCompletedTasks(), u.getLateCompletedTasks(),
				u.getPlannedTasks(),u.getUnplannedTasks());
	}

}
