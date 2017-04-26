package uo.sdi.client;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.uo.AdminService;
import com.sdi.uo.BusinessException_Exception;
import com.sdi.uo.EJBAdminServiceService;
import com.sdi.uo.User;

public class DeepDeleteUser implements Action {

	@Override
	public void execute() throws Exception {
		try {
			AdminService service = new EJBAdminServiceService()
					.getAdminServicePort();
			Long id = Console.readLong("Enter an id");
			while (id == null || id < 0) {
				System.out
						.println("That input is not valid. Please, try again");
				id = null;
				id = Console.readLong("Enter an id");
			}

			User user = service.findUserById(id);

			if (user == null)
				throw new BusinessException_Exception("There is no user with "
						+ "id " + id);

			service.deepDeleteUser(id);
			System.out.println("The user with id: " + id
					+ " has been successfully deleted");
		} catch (BusinessException_Exception b) {
			System.out.println("The user could not be deleted due to: \n\t"
					+ b.getLocalizedMessage());
		} catch (Exception e){
			System.out.println("There was a problem with the system");
		}

	}

}
