package exercises.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeTest {

	public static void main(String[] args) throws InterruptedException {
		LocalDate bDay = LocalDate.of(1986, 8, 20);
		System.out.println(bDay);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
		String formatedTime = bDay.format(formatter);
		System.out.println("formatedTime: " + formatedTime);

		LocalDate parsed = LocalDate.parse(formatedTime, formatter);

		System.out.println("parsed: " + parsed);

		Period period = Period.between(bDay, LocalDate.now());
		System.out
				.println("years: " + period.getYears() + "; months: " + period.getMonths() + "; days: " + period.getDays());
		
		System.out.println("\n\t Ticking methods:\n");
		Thread.sleep(1500);
		tick(3, 300);
		Thread.sleep(1500);
		tickWithFps(5, 30);

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
		System.out.println("For " + lengthInSec + " seconds, ticking every " + intervalInMs + " ms:\n");
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
		System.out.println("\nIn " + lengthInSec + " seconds, there were " + count + " ticks of " + intervalInMs + "ms.\n");
	}

	private static void tickWithFps(int forSecs, int targetFps) {
		System.out.println("For " + forSecs + " seconds, ticking at " + targetFps + " fps:\n");
		long oneSec = 1_000_000_000L;
		double nanoFpsRate = 1_000_000_000 / targetFps;
		int secsPast = 0;
		int totalTicks = 0;
		int fps = 0;
		Instant start = Instant.now();
		Instant secStart = Instant.now();
		Instant end;

		while (secsPast < forSecs) {
			end = Instant.now();

			if (start.until(end, ChronoUnit.NANOS) >= nanoFpsRate) {
				fps++;
				totalTicks++;
				start = Instant.now();
			}
			if (secStart.until(end, ChronoUnit.NANOS) >= oneSec) {
				secsPast += 1;
				System.out.println("Second: " + secsPast + ", ticking at: " + fps + " fps ...");
				fps = 0;
				secStart = Instant.now();
			}
		}

		System.out.println("\nIn " + (secsPast) + " seconds, there were " + totalTicks + " ticks at an average of "
				+ totalTicks / (secsPast) + " fps.");
	}
}
