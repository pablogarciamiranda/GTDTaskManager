package uo.sdi.client.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import alb.util.console.Console;

public class Login extends SynchronousReceiver{
	
	@Override
	public void execute() throws Exception {
		initialize();

		ObjectMessage m;
		String user;
		String pass;
		do{
		user = Console.readString("> Introduce your user");

		pass = Console
				.readString("> Introduce your password");

		MapMessage msg = createMessage(user, pass);
		requestProducer.send(msg);

		Message message = responseConsumer.receive();

		m = (ObjectMessage) message;
		
		if(m==null)System.out.println("User or password was incorrect");
		
		} while (m.getObject()==null);
		login = user;
		password = pass;
		id = (Long) m.getObject();
		System.out.println("Login sucessful");
		close();
		
	}
	
	private MapMessage createMessage(String user, String password) throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "login");
		msg.setString("login", user);
		msg.setString("password", password);


		// Set the tempQueue that is the queue the server will respond to
		msg.setJMSReplyTo(tempQueue);
		String correlationId = this.createRandomString();
		msg.setJMSCorrelationID(correlationId);

		return msg;
	}

}
