package uo.sdi.client;

import uo.sdi.business.AdminService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.RemoteEJBServicesLocator;
import uo.sdi.dto.User;
import alb.util.console.Console;
import alb.util.menu.Action;

public class DeepDeleteUser implements Action{

	@Override
	public void execute() throws Exception {
		AdminService service = new RemoteEJBServicesLocator().getAdminService(); 
		long id = Console.readLong("Enter an id");
		
		try{
			
			User user = service.findUserById(id);
			if (user==null){
				System.out.println("There is no user with id:"+id);
				return;
			}
			
			service.deepDeleteUser(id);
			System.out.println("The user with id "+id
					+" has been successfully deleted");
		} catch(BusinessException b){
			System.out.println("The user could not be deleted due to: \n"
					+b.getLocalizedMessage());
		}
		
		
	}

}
