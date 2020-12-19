package corejava.exercise2;

import java.util.GregorianCalendar;

public class TimeTest {

public static void main(String[] args) {
		
		tick(10, 500);

	}
	
	private static void tick(int lengthInSec, int intervalInMs) {
		GregorianCalendar time = new GregorianCalendar();
		long length = lengthInSec * 1000;
		long starttime = time.getTimeInMillis();
		long currentTime = time.getTimeInMillis();
		long step = starttime;
		int count = 0;
			
		while((currentTime - starttime) < length) {
			currentTime = GregorianCalendar.getInstance().getTimeInMillis();
			if(currentTime - step >= intervalInMs) {
				System.out.println(++count);
				step = currentTime;
			}
		}
	}

}
