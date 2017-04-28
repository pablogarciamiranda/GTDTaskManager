package uo.sdi.client.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import alb.util.console.Console;

public class FinishTask extends SynchronousReceiver {

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

		Message message = responseConsumer.receive();

		ObjectMessage m = (ObjectMessage) message;
		System.out.println(m.getObject());
		
		close();
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

	

}
