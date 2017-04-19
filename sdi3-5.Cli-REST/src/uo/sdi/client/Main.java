package uo.sdi.client;

import java.util.List;

public class Main {
	private static final String REST_ADMIN_SERVICE_URL = "http://localhost:8280/sdi3-5.Web/rest/UserServiceRs";

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		List<User> users = restGetUsers(); // A GET operation
		showUsers(users);
		String res = getUserByIdAsJsonString(users.get(0));
		System.out.println(res);
		res = getStudentByIdAsXmlString(users.get(0));
		System.out.println(res);
		User a = getUserByIdAsObject(users.get(0));
		printUser(a);
		a = createNewUser(); // A PUT operation
		updateUser(users.get(0));// A POST operation
		deleteUser(users.get(1));// A DELETE operation
		System.out.println("\n-- ws REST JAX-RS remote client ended -");
	}

	private User getUserByIdAsObject(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private void showUsers(List<User> users) {
		// TODO Auto-generated method stub

	}

	private List<User> restGetUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	private void printUser(User a) {
		// TODO Auto-generated method stub

	}

	private void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	private void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	private User createNewUser() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getUserByIdAsJsonString(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getStudentByIdAsXmlString(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getStudentByIdAsJsonString(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private void showStudents(List<User> alumnos) {
		// TODO Auto-generated method stub

	}

	private List<User> restGetAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}
}
