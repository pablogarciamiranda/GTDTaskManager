package uo.sdi.client.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

public class ListTasksToday extends SynchronousReceiver {

	@Override
	public void execute() throws Exception {
		initialize();
		MapMessage msg = createMessage();
		requestProducer.send(msg);
		
		Message message = responseConsumer.receive();

		ObjectMessage m = (ObjectMessage) message;
		System.out.println(m.getObject());
		close();
	}


	private MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "list");
		msg.setString("login", login);
		msg.setString("password",password);

		// Set the tempQueue that is the queue the server will respond to
		msg.setJMSReplyTo(tempQueue);
		String correlationId = this.createRandomString();
		msg.setJMSCorrelationID(correlationId);
		return msg;
	}

}
