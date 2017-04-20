package uo.sdi.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import uo.sdi.client.service.AdminServicesRest;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.client.validation.Authenticator;

public class RestClient {
	
	private UserServicesRest userService;
	private AdminServicesRest adminService;
	private TaskServicesRest taskService;

	public RestClient() {
		userService = new ResteasyClientBuilder()
		.build()
		.register( new Authenticator() )
		.target( "http://localhost:8280/sdi3-5.Web/rest/" )
		.proxy( UserServicesRest.class );
		
		adminService = new ResteasyClientBuilder()
		.build()
		.register( new Authenticator() )
		.target( "http://localhost:8280/sdi3-5.Web/rest/" )
		.proxy( AdminServicesRest.class );
		
		taskService = new ResteasyClientBuilder()
		.build()
		.register( new Authenticator() )
		.target( "http://localhost:8280/sdi3-5.Web/rest/" )
		.proxy( TaskServicesRest.class );
	}
	
	public UserServicesRest getUserService() {
		return userService;
	}

	public AdminServicesRest getAdminService() {
		return adminService;
	}

	public TaskServicesRest getTaskService() {
		return taskService;
	}
}
