package uo.sdi.menu;

import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import uo.sdi.client.RestClient;
import uo.sdi.client.actions.AddTask;
import uo.sdi.client.actions.FinishTask;
import uo.sdi.client.actions.ListCategories;
import uo.sdi.client.actions.ListTasks;
import uo.sdi.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {

		menuOptions = new Object[][] {
				{ "List categories", ListCategories.class },
				{ "List tasks from a category", ListTasks.class },
				{ "Finish task", FinishTask.class },
				{ "Register a task", AddTask.class } };
	}

	public static void main(String... args) {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		RestClient client = new RestClient();
		new MainMenu().execute(client.getUserService(),
				client.getAdminService(), client.getTaskService());
	}
}
