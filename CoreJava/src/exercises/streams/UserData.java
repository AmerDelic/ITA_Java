package exercises.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

/* Exercise 1:
 * 
 * You are given a file users.txt, with the following content:
 * 
	id:01|firstName:Petar|lastName:Petrovic|jmbg:1234567890123
	id:02|firstName:Jovan|lastName:Jovanovic|jmbg:1234567890124
	id:03|firstName:Nikola|lastName:Nikolic|jmbg:1234567890125
	
	• Create an application that will read the file and output its data in the following format:
	
	User Id: 01
	First name: Petar
	Last name: Petrovic
	Jmbg: 1234567890123
	------------------------------------
	User Id: 02
	First name: Jovan
	Last name: Jovanovic
	Jmbg: 123456789024
	
 */

public class UserData {

	String source;

	public UserData(String source) {
		this.source = source;
	}

	private String retrieveUserdata() {
		StringBuilder results = new StringBuilder();
		try (Scanner sc = new Scanner(new FileInputStream(source))) {
			StringBuilder sb = new StringBuilder();
			while (true) {
				sc.findInLine("id:(\\d+)\\Q|\\EfirstName:(\\w+)\\Q|\\ElastName:(\\w+)\\Q|\\Ejmbg:(\\d+)");
				MatchResult matchResult = sc.match();
				for (int i = 1; i <= matchResult.groupCount(); i++) {
					results.append(matchResult.group(i) + "\n");

				}
				if (!sc.hasNextLine())
					break;
				sc.nextLine();
			}
			String data = results.toString();
			return data;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Scanner sc2 = new Scanner(retrieveUserdata());

		while (sc2.hasNext()) {
			users.add(new User(sc2.nextInt(), sc2.next(), sc2.next(), sc2.nextLong()));
		}
		return users;
	}
}











