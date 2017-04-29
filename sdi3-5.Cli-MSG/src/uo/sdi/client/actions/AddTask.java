package uo.sdi.client.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import uo.sdi.client.model.Task;
import uo.sdi.util.FreijeyPabloUtil;
import alb.util.console.Console;
import alb.util.date.DateUtil;

import com.google.gson.Gson;


public class AddTask extends SynchronousReceiver {


	@Override
	public void execute() throws Exception {
		initialize();
		Task task = new Task();

		// Title of the task
		String title = Console.readString("> Introduce a title for the task");
		if (title == null || title.trim().isEmpty()) {
			System.out.println("That input is not valid. Please, try again");
			title = null;
			title = Console.readString("> Introduce a title for the task");
		}
		task.setTitle(title);

		// Comments of the task
		String comments = Console
				.readString("> Introduce a comment for the task");
		task.setComments(comments);

		// Category of the task
		Long categoryId = Console
				.readLong("> Introduce the id of a category or 0 to set no category");
		while (categoryId == null || categoryId < 0) {
			System.out.println("That input is not valid. Please, try again");
			categoryId = null;
			categoryId = Console
					.readLong("> Introduce the id of a category or 0 to set no category");
		}
		if (categoryId == 0)
			categoryId = null;
		task.setCategoryId(categoryId);
		task.setUserId(id);
		
		//Planned date
		String response = "";
		do {
			response = Console
					.readString("> Do you want a planned date? (y/n)");

		} while (!response.equals("yes") && !response.equals("no")
				&& !response.equals("y") && !response.equals("n"));

		String date = "";
		do {
			System.out.println("> Please, introduce a valid date");
			if (response.equals("yes") || response.equals("y")) {
				String day = Console.readString("\t> Introduce a valid day (dd)");
				String month = Console
						.readString("\t> Introduce a valid month (mm)");
				String year = Console
						.readString("\t> Introduce a valid year (yyyy)");
				date = day + "/" + month + "/" + year;

			}
		} while (!FreijeyPabloUtil.isDateValid(date));
		
		if (response.equals("yes") || response.equals("y")){
			task.setPlanned(DateUtil.fromString(date));
		}

		MapMessage msg = createMessage(task);
		requestProducer.send(msg);

		Message message = responseConsumer.receive();

		ObjectMessage m = (ObjectMessage) message;
		System.out.println(m.getObject());
		close();
	}

	private MapMessage createMessage(Task task) throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "add");

		// We convert the Task to JSON
		Gson gson = new Gson();
		String jsonTask = gson.toJson(task);
		msg.setString("task", jsonTask);
		msg.setString("login", login);
		msg.setString("password",password);

		// Set the tempQueue that is the queue the server will respond to
		msg.setJMSReplyTo(tempQueue);
		String correlationId = this.createRandomString();
		msg.setJMSCorrelationID(correlationId);

		return msg;
	}

}
