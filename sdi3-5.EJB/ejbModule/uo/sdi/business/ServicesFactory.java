package uo.sdi.business;

public interface ServicesFactory {
	
	TaskService getTaskService();
	AdminService getAdminService();
	UserService getUserService();

}
