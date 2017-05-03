package uo.sdi.menu;

import uo.sdi.client.actions.DeepDeleteUser;
import uo.sdi.client.actions.DisableUser;
import uo.sdi.client.actions.ListUsers;
import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {

		menuOptions = new Object[][] { { "List users", ListUsers.class },
				{ "Enable/Disable user", DisableUser.class },
				{ "Delete user", DeepDeleteUser.class } };
	}

	public static void main(String... args) {
		System.out
				.println("Welcome to the EJB client developed by Pablo García Miranda & Fernando Freije Fuente!");
		new MainMenu().execute();
	}
}
