package corejava.exercise5;

import java.util.List;

public class Tester {
	static String test = "[{id:10,x:10,y:20d},{id:5,x:30,y:40d},{id:2,x:2,y:7d}]";

	public static void main(String[] args) {

		PositionReader posRead = new PositionReader();
		List<UserPosition> testing = posRead.readPosition(test);
		for (UserPosition up : testing) {
			System.out.println(up.toString());
		}
	}
}
