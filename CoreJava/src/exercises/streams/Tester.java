package exercises.streams;

import java.io.File;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		
		// Exercise 1:
//		UserData ud = new UserData("user");	
//		List<User> users = ud.getUsers();
//		for(User u : users) {
//			System.out.println(u.toString() + "\n----------------------");
//		}

		// Exercise 2:
//		FileCombiner combiner = new FileCombiner("firstFile", "secondFile", "thirdFile");
//		File thirdFile = combiner.merge();

		// Exercise 3:
//		WebCrawler crawler = new WebCrawler("https://www.klix.ba/");
//		List<String> pagesList = crawler.crawl();
//		pagesList.stream().forEach(System.out::println);
	
		// Exercise 4:
		Transaction transaction = new Transaction(1, 2, 50.00);
		transaction.transfer();
	}
}
