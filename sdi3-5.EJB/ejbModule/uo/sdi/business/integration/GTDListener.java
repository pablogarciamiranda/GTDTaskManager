package uo.sdi.business.integration;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.task.LocalTaskService;
import uo.sdi.business.impl.user.LocalUserService;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/MessagesQueue") })
public class GTDListener implements MessageListener {

	@EJB(beanInterface = LocalTaskService.class)
	private TaskService taskService;

	@EJB(beanInterface = LocalUserService.class)
	private UserService userService;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory factory;

	@Resource(mappedName = "java:/queue/InvalidMessagesQueue")
	private Destination queue;

	private static String auth_error = "Authentication error.";
	private static String invalid_format = "Invalid format of the message";

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
		if (!messageOfExpectedType(msg))
			return invalid_format;
		MapMessage m = (MapMessage) msg;
		String cmd = m.getString("command");
		if ("list".equals(cmd)) {
			return listTodayTasks(m);
		} else if ("finish".equals(cmd)) {
			return finishTask(m);
		} else if ("add".equals(cmd)) {
			return addTask(m);
		} else if ("login".equals(cmd)) {
			return login(m);
		}
		return invalid_format;
	}

	private Object login(MapMessage msg) {

		try {
			String login = msg.getString("login");
			String password = msg.getString("password");
			User user = userService.findLoggableUser(login);

			if (user == null) {
				return auth_error;
			}
			if (user.getPassword().equals(password)) {
				return user.getId();
			}
			return auth_error;
		} catch (JMSException | BusinessException e1) {
			e1.printStackTrace();
		}
		return auth_error;
	}

	private boolean verify(MapMessage msg) {
		String login = null;
		String password = null;
		User user = null;
		try {
			login = msg.getString("login");
			password = msg.getString("password");
			user = userService.findLoggableUser(login);
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (user == null) {
			return false;
		}
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	private String addTask(MapMessage msg) {
		Gson gson = new Gson();
		Task task = null;
		try {
			// Deserialize object from JSON
			task = gson.fromJson(msg.getString("task"), Task.class);
		} catch (JsonSyntaxException | JMSException e1) {
			e1.printStackTrace();
			return "invalid_format";
		}
		try {
			if (!verify(msg)) {
				return auth_error;
			}
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
			return invalid_format;
		}
		try {
			if (!verify(msg)) {
				return "Authentication error";
			}
			taskService.markTaskAsFinished(taskId);
			return "The task with id '" + taskId
					+ "' has been marked as finished.";
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "The task with id '" + taskId
				+ "' has not been marked as finished.";
	}

	private Object listTodayTasks(MapMessage msg) {
		Long userId = null;
		try {
			userId = msg.getLong("userId");
		} catch (JMSException e1) {
			e1.printStackTrace();
			return invalid_format;
		}
		try {
			if (!verify(msg)) {
				return auth_error;
			}
			List<Task> tasks = taskService
					.findFinishedTodayTasksByUserId(userId);
			return showTasks(tasks);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "There was a problem when trying to list the tasks";
	}

	private String showTasks(List<Task> tasks) {
		String header = "%s %s %s %s %s %s \n";
		String result = String.format(header, "_ID_", "_CATEGORY_ID",
				"_NAME____________________________________",
				"_CREATED_____________________",
				"_PLANNED_____________________",
				"_FINISHED_____________________");

		for (Task t : tasks) {
			result += showTask(t);
		}
		return result;
	}

	private String showTask(Task t) {
		String finished;
		if (t.getFinished() == null)
			finished = "";
		else
			finished = t.getFinished().toString();
		String planned;
		if (t.getPlanned() == null)
			planned = "";
		else
			planned = t.getPlanned().toString();
		String created;
		if (t.getCreated() == null)
			created = "";
		else
			created = t.getCreated().toString();

		String header = "%-10s %-8s %-18s %-30s %-30s %-30s\n";
		return String.format(header, t.getId(), t.getCategoryId(),
				t.getTitle(), created, planned, finished);
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

			if (processedMessage.equals(auth_error)
					||processedMessage.equals(invalid_format)) {
				// Send the response to the InvalidQueue
				ObjectMessage response = session.createObjectMessage();
				response.setObject(processedMessage);
				MessageProducer replyProducer = session.createProducer(queue);
				replyProducer.send(response);
			}
			// Create the response to the Client with the processedMessage
			ObjectMessage response = session.createObjectMessage();
			response.setObject(processedMessage);

			// We send the send the response to the temporaryQueue
			MessageProducer replyProducer = session.createProducer(null);
			replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
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
