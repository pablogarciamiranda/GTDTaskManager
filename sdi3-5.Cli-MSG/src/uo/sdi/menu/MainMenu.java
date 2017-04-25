package uo.sdi.menu;


import uo.sdi.client.actions.AddTask;
import uo.sdi.client.actions.FinishTask;
import uo.sdi.client.actions.ListTasksToday;
import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {

		menuOptions = new Object[][] { { "List tasks delayed of Today ", ListTasksToday.class },
				{ "Finish task", FinishTask.class },
				{ "Add task", AddTask.class } };
	}

	public static void main(String... args) {
		System.out
				.println("Welcome to the MSG client developed by Pablo García Miranda & Fernando Freije Fuente!");
		new MainMenu().execute();
	}
}
