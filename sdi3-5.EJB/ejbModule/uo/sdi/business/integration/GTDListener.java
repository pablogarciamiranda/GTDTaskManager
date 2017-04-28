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
	public void onMessage(Message msg) {
		System.out.println("GTD: Msg received");
		try {
			Object object = process(msg);
			sendResponse((Serializable) object);
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
			task = gson.fromJson(msg.getString("task"), Task.class);
		} catch (JsonSyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			taskService.createTask(task);
			return "The task " + task.getTitle() + " has been added correctly.";
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "The task has not been added";
	}

	private String finishTask(MapMessage msg) {
		try {
			taskService.markTaskAsFinished(msg.getLong("taskId"));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private Object listTodayTasks() {
		try {
			return taskService.findFinishedTodayTasksByUserId(272L);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean messageOfExpectedType(Message msg) {
		// TODO Auto-generated method stub
		return true;
	}

	private void sendResponse(Serializable object) {
		Connection con = null;
		try {
			con = factory.createConnection("sdi", "password");
			Session session = con
					.createSession(false, Session.AUTO_ACKNOWLEDGE);
			ObjectMessage message = session.createObjectMessage();
			message.setObject(object);
			MessageProducer sender = session.createProducer(message
					.getJMSReplyTo());
			sender.send(message);
		} catch (JMSException jex) {
			jex.printStackTrace();
		} finally {
			close(con);
		}

	}

	private void close(Connection con) {
		// TODO Auto-generated method stub

	}

}
