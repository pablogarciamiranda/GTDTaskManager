package uo.sdi.client.actions;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import com.google.gson.Gson;

import uo.sdi.client.model.Task;
import uo.sdi.util.Jndi;
import alb.util.console.Console;
import alb.util.menu.Action;

public class AddTask implements Action {

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String NOTANEITOR_QUEUE = "jms/queue/SendMessagesQueue";
	private Connection con;
	private Session session;
	private MessageProducer sender;

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
		
		MapMessage msg = createMessage(task);
		showMessage(msg);
		sender.send(msg);
		close();
	}

	private void showMessage(MapMessage msg) {
		msg.toString();
	}

	private void close() {
		try {
			con.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void initialize() throws JMSException {
		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);
		Destination queue = (Destination) Jndi.find(NOTANEITOR_QUEUE);
		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		sender = session.createProducer(queue);
		con.start();
	}

	private MapMessage createMessage(Task task) throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "add");
		Gson gson = new Gson();
		String jsonTask = gson.toJson(task);
		
		msg.setString("task", jsonTask);
		return msg;
	}

}
