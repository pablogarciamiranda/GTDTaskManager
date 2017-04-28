package uo.sdi.client.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;

public class ListTasksToday extends AbstractListener {

	@Override
	public void execute() throws Exception {
		initialize();
		MapMessage msg = createMessage();
		requestProducer.send(msg);
		close();
	}

	private MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "list");

		// Set the tempQueue that is the queue the server will respond to
		msg.setJMSReplyTo(tempQueue);
		String correlationId = this.createRandomString();
		msg.setJMSCorrelationID(correlationId);
		return msg;
	}


}
