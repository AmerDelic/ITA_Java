package exercises.exercise2;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class TimeTest {

	public static void main(String[] args) {
		String test = "(22052014,44.756364,20.412598,051230,051230,123143124122)";
		//tick(10, 100);
		LocalDate dateTime = LocalDate.of(2014, 5, 22);
		System.out.println(dateTime);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
		String temp =	dateTime.format(formatter);
		System.out.println("temp: " + temp);
		
		LocalDate parsed = LocalDate.parse(temp, formatter);
		
		System.out.println("parsed: " + parsed);
		
		String datetest = "22052014";
		System.out.println(datetest.substring(0, 2));
	
		
		int day = Integer.valueOf(datetest.substring(0, 2));
		
		System.out.println(day);
//		LocalDate present = LocalDate.now();
//		LocalDate present2 = LocalDate.now(Clock.systemDefaultZone());
//		LocalDateTime dateTime = LocalDateTime.now();
//
//		System.out.println(present);
//		System.out.println("ChronoField.YEAR & getYear()");
//		System.out.println(present.get(ChronoField.YEAR));
//		System.out.println(present.getYear() + "\n");
//
//		System.out.println("getMonth() & getDayOfMonth()");
//		System.out.println(present.getMonth());
//		System.out.println(present.getDayOfMonth() + "\n");
//
//		System.out.println("ChronoField.DAY_OF_WEEK");
//		System.out.println(present.get(ChronoField.DAY_OF_WEEK));
//
//		System.out.println("\n present2 with Clock:");
//		System.out.println(present2);
//		System.out.println("ChronoField.YEAR & getYear()");
//		System.out.println(present2.get(ChronoField.YEAR));
//		System.out.println(present2.getYear() + "\n");
//
//		System.out.println("getMonth() & getDayOfMonth()");
//		System.out.println(present2.getMonth());
//		System.out.println(present2.getDayOfMonth() + "\n");
//
//		System.out.println("ChronoField.DAY_OF_WEEK");
//		System.out.println(present2.get(ChronoField.DAY_OF_WEEK));
//
//		System.out.println("\ndateTime:");
//		System.out.println(dateTime);
//		System.out.println("ChronoField.YEAR & getYear()");
//		System.out.println(dateTime.get(ChronoField.YEAR));
//		System.out.println(dateTime.getYear() + "\n");
//
//		System.out.println("getMonth() & getDayOfMonth()");
//		System.out.println(dateTime.getMonth());
//		System.out.println(dateTime.getDayOfMonth() + "\n");
//
//		System.out.println("ChronoField.DAY_OF_WEEK .. hour, minute, second");
//		System.out.println(dateTime.get(ChronoField.DAY_OF_WEEK));
//		System.out.println(dateTime.get(ChronoField.HOUR_OF_DAY));
//		System.out.println(dateTime.get(ChronoField.MINUTE_OF_HOUR));
//		System.out.println(dateTime.get(ChronoField.SECOND_OF_MINUTE));

	}

	private static void tick(int lengthInSec, int intervalInMs) {
		LocalTime time = LocalTime.now();
		long length = lengthInSec * 1000;
		long starttime = time.getLong(ChronoField.MILLI_OF_DAY);
		long currentTime = starttime;
		long step = starttime;
		int count = 0;

		while ((currentTime - starttime) < length) {
			currentTime = LocalTime.now().getLong(ChronoField.MILLI_OF_DAY);
			if (currentTime - step >= intervalInMs) {
				System.out.println(++count);
				step = currentTime;
			}
		}
	}

}
