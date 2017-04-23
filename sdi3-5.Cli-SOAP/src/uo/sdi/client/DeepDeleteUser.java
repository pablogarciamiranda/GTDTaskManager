package uo.sdi.client;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.uo.AdminService;
import com.sdi.uo.BusinessException_Exception;
import com.sdi.uo.EJBAdminServiceService;
import com.sdi.uo.User;

public class DeepDeleteUser implements Action{

	@Override
	public void execute() throws Exception {
		AdminService service = new EJBAdminServiceService().getAdminServicePort(); 
		long id = Console.readLong("Enter an id");
		
		try{
			
			User user = service.findUserById(id);
			if (user==null){
				System.out.println("No hay ningun usuario con ese id");
				return;
			}
			
			service.deepDeleteUser(id);
			System.out.println("El usuario con id "+id
					+" ha sido eliminado adecuadamente");
		} catch(BusinessException_Exception b){
			System.out.println("The user could not be deleted due to: \n"
					+b.getLocalizedMessage());
		}
		
	}

}
