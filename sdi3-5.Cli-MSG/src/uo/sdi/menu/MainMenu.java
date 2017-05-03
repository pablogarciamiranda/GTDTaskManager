package uo.sdi.menu;


import uo.sdi.client.actions.AddTask;
import uo.sdi.client.actions.FinishTask;
import uo.sdi.client.actions.ListTasksToday;
import uo.sdi.client.actions.Login;
import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {

		menuOptions = new Object[][] { { "List tasks delayed of Today ", ListTasksToday.class },
				{ "Finish task", FinishTask.class },
				{ "Add task", AddTask.class } };
	}

	public static void main(String... args) {
		try {
			new Login().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MainMenu().execute();
	}
}
