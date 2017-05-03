package uo.sdi.client.actions;

import java.util.List;

import uo.sdi.business.AdminService;
import uo.sdi.client.service.Services;
import uo.sdi.dto.UserInfo;
import alb.util.menu.Action;

public class ListUsers implements Action{

	@Override
	public void execute() throws Exception {
		try{
			AdminService service = Services.getAdminService();
			List<UserInfo> users = service.findAllUsersInfo();
			printHeader();
			for (UserInfo u : users) {
				printLine(u);
			}
		} catch (Exception e){
			System.out.println("There was a problem with the system");
		}
		
	}

	private void printHeader() {
		System.out.printf("%s %s %s %s %s %s %s \n", "_ID__", "_LOGIN_________",
				 "_EMAIL___________", "_Tasks Finished___________",
				"_Tasks Finished Late___________","_Tasks Planned___________", "_Tasks Unplanned___________");
	}

	private void printLine(UserInfo u) {
		System.out.printf("%-5s %-15s %-18s %-30s %-30s %-30s %-30s\n", u.getId(), u.getLogin(),
				u.getEmail(), u.getCompletedTasks(), u.getLateCompletedTasks(),
				u.getPlannedTasks(),u.getUnplannedTasks());
	}

}
