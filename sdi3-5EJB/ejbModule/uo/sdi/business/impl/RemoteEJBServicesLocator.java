package uo.sdi.business.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import uo.sdi.business.AdminService;
import uo.sdi.business.ServicesFactory;
import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;

public class RemoteEJBServicesLocator implements ServicesFactory {

	private static final String USER_SERVICE_JNDI_KEY = "sdi3-5/"
			+ "sdi3-5.EJB/" + "EJBUserService!"
			+ "uo.sdi.business.impl.user.RemoteUserService";

	private static final String ADMIN_SERVICE_JNDI_KEY = "sdi3-5/"
			+ "sdi3-5.EJB/" + "EJBAdminService!"
			+ "uo.sdi.business.impl.admin.RemoteAdminService";

	private static final String TASK_SERVICE_JNDI_KEY = "sdi3-5/"
			+ "sdi3-5.EJB/" + "EJBTaskService!"
			+ "uo.sdi.business.impl.user.RemoteTaskService";

	@Override
	public TaskService getTaskService() {
		System.out.println("Using remote services locator");
		try {
			Context ctx = new InitialContext();
			// Nos devuelve un objeto que implementa el servicio creado y
			// gestionado por el contenedor
			return (TaskService) ctx.lookup(TASK_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public AdminService getAdminService() {
		System.out.println("Using remote services locator");
		try {
			Context ctx = new InitialContext();
			// Nos devuelve un objeto que implementa el servicio creado y
			// gestionado por el contenedor
			return (AdminService) ctx.lookup(ADMIN_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public UserService getUserService() {
		System.out.println("Using remote services locator");
		try {
			Context ctx = new InitialContext();
			// Nos devuelve un objeto que implementa el servicio creado y
			// gestionado por el contenedor
			return (UserService) ctx.lookup(USER_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

}
