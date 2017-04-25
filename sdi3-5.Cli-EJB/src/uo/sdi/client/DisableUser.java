package uo.sdi.client;

import uo.sdi.business.AdminService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.RemoteEJBServicesLocator;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import alb.util.console.Console;
import alb.util.menu.Action;

public class DisableUser implements Action {

	@Override
	public void execute() throws Exception {

		try {
			AdminService service = new RemoteEJBServicesLocator()
					.getAdminService();
			Long id = null;
			while (id == null) {
				id = Console.readLong("Enter an id: ");
				if (id == null || id < 0) {
					System.out
							.println("That input is not valid. Please, try again");
					id = null;
				}
			}

			User user = service.findUserById(id);

			if (user == null)
				throw new BusinessException("There is no user with" + "id "
						+ id);

			if (user.getStatus().equals(UserStatus.ENABLED)) {
				service.disableUser(id);
				System.out.println("The user with id " + id + " has been "
						+ "successfully disabled");
			} else {
				service.enableUser(id);
				System.out.println("The user with id " + id + " has been "
						+ "successfully enabled");
			}
		} catch (BusinessException b) {
			System.out.println("The user could not be disabled due to: \n"
					+ b.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("There was a problem with the system");
		}
	}

}
