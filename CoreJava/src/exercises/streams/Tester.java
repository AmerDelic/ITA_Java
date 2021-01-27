package exercises.streams;

import java.util.List;

public class Tester {

	public static void main(String[] args) {

		UserData ud = new UserData("user");
		
		List<User> users = ud.getUsers();
		
		for(User u : users) {
			System.out.println(u.toString() + "\n----------------------");
		}

	}
}
