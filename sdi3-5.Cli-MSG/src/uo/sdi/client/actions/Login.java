package uo.sdi.client.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import alb.util.console.Console;

public class Login extends SynchronousReceiver {

	private static String auth_error = "Authentication error.";

	@Override
	public void execute() throws Exception {
		initialize();

		ObjectMessage m;
		String user;
		String pass;
		do {
			user = Console.readString("> Introduce your user");

			pass = Console.readString("> Introduce your password");

			MapMessage msg = createMessage(user, pass);
			requestProducer.send(msg);

			Message message = responseConsumer.receive();

			m = (ObjectMessage) message;

			if (m.getObject().equals(auth_error))
				System.out.println(auth_error);

		} while (m.getObject().equals(auth_error));
		login = user;
		password = pass;
		id = (Long) m.getObject();
		System.out.println("Login sucessful");
		System.out
				.println("Welcome to the MSG client developed by Pablo García Miranda & Fernando Freije Fuente!");
		close();

	}

	private MapMessage createMessage(String user, String password)
			throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "login");
		msg.setString("login", user);
		msg.setString("password", password);

		// Set the tempQueue that is the queue the server will respond to
		msg.setJMSReplyTo(tempQueue);

		return msg;
	}

}
