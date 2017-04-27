package uo.sdi.client.actions;

import uo.sdi.client.RestClient;
import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.model.Task;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;
import uo.sdi.menu.Action;
import alb.util.console.Console;

public class FinishTask implements Action {

	@Override
	public void execute(UserServicesRest userServiceRest,
			TaskServicesRest taskServicesRest, RestClient client)
			throws BusinessException {

		try {
			// Id of the task
			Long taskId = Console.readLong("> Choose a taskId to finish");
			while (taskId == null || taskId < 0) {
				System.out
						.println("That input is not valid. Please, try again");
				taskId = null;
				taskId = Console.readLong("> Choose a taskId to finish");
			}
			Task task = taskServicesRest.findTaskById(taskId);
			if (task == null) {
				throw new BusinessException("There is no task with id "
						+ taskId);
			}

			// Mark task as finished
			taskServicesRest.markTaskAsFinished(taskId);
			System.out.println("The task " + task.getTitle()
					+ " has been marked as finished.");

		} catch (BusinessException b) {
			System.out
					.println("The task can not be marked as finished due to due to: \n\t"
							+ b.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("There was a problem with the system");
		}
	}
}
