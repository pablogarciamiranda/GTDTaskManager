package uo.sdi;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import uo.sdi.util.Jndi;

public class Main {

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String NOTANEITOR_QUEUE = "jms/queue/SendMessagesQueue";
	private Connection con;
	private Session session;
	private MessageProducer sender;

	public static void main(String[] args) throws JMSException {
		new Main().run();
	}

	private void run() throws JMSException {
		initialize();
		for (int i = 0; i < 5; i++) {
			MapMessage msg = createMessage(i);
			showMessage(msg);
			sender.send(msg);
		}
		close();
	}

	private void showMessage(MapMessage msg) {
		msg.toString();
	}

	private void close() {
		try {
			con.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
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

	private MapMessage createMessage(int i) throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "add");
		msg.setString("title", "Prueba " + i);
		msg.setString("comments", "");
		msg.setString("userId",
				"272");
		msg.setString("categoryId", "215");
		return msg;
	}

}
