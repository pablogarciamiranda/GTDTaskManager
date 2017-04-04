package uo.sdi.business;

import uo.sdi.business.impl.LocalEJBServicesLocator;
import uo.sdi.business.impl.admin.EJBAdminService;
import uo.sdi.business.impl.task.EJBTaskService;
import uo.sdi.business.impl.user.EJBUserService;

public class Services {

	public static ServicesFactory services = new LocalEJBServicesLocator();
}
