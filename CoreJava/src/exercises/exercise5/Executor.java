package exercises.exercise5;

import java.util.List;

public class Executor {
	static String test = "[{id:10,x:10,y:20d},{id:5,x:30,y:40d},{id:2,x:2,y:7d}]";
	
	public static void main(String[] args) {
		
		PositionReader reader = new PositionReader();
		List<UserPosition> positions = reader.readPosition(test);
		
		for(UserPosition up : positions) {
			System.out.println(up);
		}

	}

}
