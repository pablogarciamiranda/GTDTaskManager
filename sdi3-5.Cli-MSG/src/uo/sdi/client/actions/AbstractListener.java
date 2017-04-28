package uo.sdi.client.actions;

import java.io.Serializable;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TemporaryQueue;

import uo.sdi.util.Jndi;
import alb.util.menu.Action;

public abstract class AbstractListener implements Action, MessageListener {

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String MESSAGES_QUEUE = "jms/queue/MessagesQueue";
	private Connection con;
	protected Session session;
	protected MessageProducer requestProducer;
	private MessageConsumer responseConsumer;
	protected TemporaryQueue tempQueue;
	
	
	@Override
	public abstract void execute() throws Exception;
	
	protected void close() {
		try {
			con.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	protected void initialize() throws JMSException {
		// We initialize the Connection, Session and requestProducer
		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);
		Destination queue = (Destination) Jndi.find(MESSAGES_QUEUE);
		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		requestProducer = session.createProducer(queue);
		requestProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		// The client will receive the messages from the server in a temporary
		// queue, and also it will be responsible of handling the messages of
		// the tempQueue
		tempQueue = session.createTemporaryQueue();
		responseConsumer = session.createConsumer(tempQueue);
		responseConsumer.setMessageListener(this);

		con.start();
	}
	
	protected String createRandomString() {
		Random random = new Random(System.currentTimeMillis());
		long randomLong = random.nextLong();
		return Long.toHexString(randomLong);
	}

	@Override
	public void onMessage(Message message) {
		Serializable messageText = null;
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				messageText = objectMessage.getObject();
				System.out.println(messageText.toString());
			}
		} catch (JMSException e) {
			// Handle the exception appropriately
		}
	}
}
