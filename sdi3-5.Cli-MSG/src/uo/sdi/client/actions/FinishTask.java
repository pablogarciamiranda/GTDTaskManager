package uo.sdi.client.actions;

import java.io.Serializable;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TemporaryQueue;

import uo.sdi.util.Jndi;
import alb.util.console.Console;
import alb.util.menu.Action;

public class FinishTask implements Action, MessageListener {

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String MESSAGES_QUEUE = "jms/queue/MessagesQueue";
	private Connection con;
	private Session session;
	private MessageProducer requestProducer;
	private MessageConsumer responseConsumer;
	private TemporaryQueue tempQueue;

	@Override
	public void execute() throws Exception {
		initialize();
		// Id of the task
		Long taskId = Console.readLong("> Choose a taskId to finish");
		while (taskId == null || taskId < 0) {
			System.out.println("That input is not valid. Please, try again");
			taskId = null;
			taskId = Console.readLong("> Choose a taskId to finish");
		}
		MapMessage msg = createMessage(taskId);
		requestProducer.send(msg);

		responseConsumer = session.createConsumer(tempQueue);
		Message message = responseConsumer.receive();

		ObjectMessage m = (ObjectMessage) message;
		System.out.println(m.getObject());
		
		close();
	}

	private void close() {
		try {
			con.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void initialize() throws JMSException {
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

		con.start();
	}

	private MapMessage createMessage(Long taskId) throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "finish");
		msg.setLong("taskId", taskId);

		// Set the tempQueue that is the queue the server will respond to
		msg.setJMSReplyTo(tempQueue);
		String correlationId = this.createRandomString();
		msg.setJMSCorrelationID(correlationId);
		return msg;
	}

	private String createRandomString() {
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
