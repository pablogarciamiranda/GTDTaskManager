package uo.sdi.business.integration;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.task.LocalTaskService;
import uo.sdi.dto.Task;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/MessagesQueue") })
public class GTDListener implements MessageListener {

	@EJB(beanInterface = LocalTaskService.class)
	private TaskService taskService;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory factory;

	@Override
	public void onMessage(Message message) {
		System.out.println("GTD: Msg received");
		try {
			Object response = process(message);
			sendResponse(message, (Serializable) response);
		} catch (JMSException jex) {
			jex.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private Object process(Message msg) throws BusinessException, JMSException {
		if (!messageOfExpectedType(msg)) {
			System.out.println("Not of expected type " + msg);
			return null;
		}
		MapMessage m = (MapMessage) msg;
		String cmd = m.getString("command");
		if ("list".equals(cmd)) {
			return listTodayTasks();
		} else if ("finish".equals(cmd)) {
			return finishTask(m);
		} else if ("add".equals(cmd)) {
			return addTask(m);
		}
		return null;
	}

	private String addTask(MapMessage msg) {
		Gson gson = new Gson();
		Task task = null;
		try {
			// Deserialize object from JSON
			task = gson.fromJson(msg.getString("task"), Task.class);
		} catch (JsonSyntaxException | JMSException e1) {
			e1.printStackTrace();
		}
		try {
			taskService.createTask(task);
			return "The task " + task.getTitle() + " has been added correctly.";
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "The task has not been added";
	}

	private String finishTask(MapMessage msg) {
		Long taskId = null;
		try {
			taskId = msg.getLong("taskId");
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		try {
			taskService.markTaskAsFinished(taskId);
			return "The task with id '" + taskId
					+ "' has been marked as finished.";
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "The task with id '" + taskId
				+ "' has not been marked as finished.";
	}

	private Object listTodayTasks() {
		try {
			taskService.findFinishedTodayTasksByUserId(272L);
			return "Perfecto";
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean messageOfExpectedType(Message msg) {
		return !(msg instanceof MapMessage) ? false : true;
	}

	private void sendResponse(Message request, Serializable processedMessage) {
		Connection con = null;
		try {
			// We initialize the Connection and Session
			con = factory.createConnection("sdi", "password");
			Session session = con
					.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the response to the Client with the processedMessage
			ObjectMessage response = session.createObjectMessage();
			response.setJMSCorrelationID(request.getJMSCorrelationID());
			response.setObject(processedMessage);

			// We send the send the response to the temporaryQueue
			MessageProducer replyProducer = session.createProducer(null);
			replyProducer.send(request.getJMSReplyTo(), response);

		} catch (JMSException jex) {
			jex.printStackTrace();
		} finally {
			close(con);
		}
	}

	private void close(Connection con) {
		try {
			con.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
