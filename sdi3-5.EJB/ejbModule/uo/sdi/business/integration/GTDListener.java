package uo.sdi.business.integration;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.task.LocalTaskService;
import uo.sdi.dto.Task;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/SendMessagesQueue") })
public class GTDListener implements MessageListener {

	@EJB(beanInterface = LocalTaskService.class)
	private TaskService taskService;

	@Override
	public void onMessage(Message msg) {
		System.out.println("GTD: Msg received");
		try {
			process(msg);
		} catch (JMSException jex) {
			jex.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private void process(Message msg) throws BusinessException, JMSException {
		if (!messageOfExpectedType(msg)) {
			System.out.println("Not of expected type " + msg);
			return;
		}
		MapMessage m = (MapMessage) msg;
		String cmd = m.getString("command");
		if ("list".equals(cmd)) {
			listTodayTasks();
		} else if ("finish".equals(cmd)) {
			finishTask(m);
		} else if ("add".equals(cmd)) {
			addTask(m);
		}
	}

	private void addTask(MapMessage msg) {
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
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void finishTask(MapMessage msg) {
		try {
			taskService.markTaskAsFinished(msg.getLong("taskId"));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void listTodayTasks() {
		try {
			taskService.findFinishedTodayTasksByUserId(272L);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private boolean messageOfExpectedType(Message msg) {
		// TODO Auto-generated method stub
		return true;
	}

}
