package uo.sdi.client;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.uo.AdminService;
import com.sdi.uo.BusinessException_Exception;
import com.sdi.uo.EJBAdminServiceService;
import com.sdi.uo.User;
import com.sdi.uo.UserStatus;

public class DisableUser implements Action{

	@Override
	public void execute() throws Exception {
		AdminService service = new EJBAdminServiceService().getAdminServicePort();
		long id = Console.readLong("Enter an id: ");	
		try{
			User user = service.findUserById(id);
			if (user==null){
				System.out.println("There is no user with id:"+id);
				return;
			}
				
			if(user.getStatus().equals(UserStatus.ENABLED)){
				service.disableUser(id);
				System.out.println("The user with id "+id+" has been "
						+ "successfully disabled");
			}
			else{
				service.enableUser(id);
				System.out.println("The user with id "+id+" has been "
						+ "succesfully enabled");
			}	
		} catch(BusinessException_Exception b){
			System.out.println("The user could not be disabled due to: \n"
					+b.getLocalizedMessage());
		}
		
	}

}
