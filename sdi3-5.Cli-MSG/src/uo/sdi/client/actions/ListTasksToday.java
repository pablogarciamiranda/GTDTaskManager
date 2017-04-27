package uo.sdi.client.actions;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import uo.sdi.util.Jndi;
import alb.util.menu.Action;

public class ListTasksToday implements Action {

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String NOTANEITOR_QUEUE = "jms/queue/SendMessagesQueue";
	private Connection con;
	private Session session;
	private MessageProducer sender;

	@Override
	public void execute() throws Exception {
		initialize();
		MapMessage msg = createMessage();
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

	private MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "list");
		return msg;
	}

}
