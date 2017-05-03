package uo.sdi.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import uo.sdi.business.AdminService;

public class Services {

	private static final String ADMIN_SERVICE_JNDI_KEY = "sdi3-5/"
			+ "sdi3-5.EJB/" + "EJBAdminService!"
			+ "uo.sdi.business.impl.admin.RemoteAdminService";
	
	public static AdminService getAdminService() {
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
}
