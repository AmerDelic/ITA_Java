package exercises.exercise6;

import java.time.LocalDateTime;

public class SpaceTime {
	private LocalDateTime dateTime;
	private double latitude;
	private double longitude;
	private String name;

	private SpaceTime(LocalDateTime dateTime, double latitude, double longitude, String name) {
		this.dateTime = dateTime;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
	}

	public static SpaceTime getInstance(String input) {
		String[] temp = stripAndExtract(input);
		return new SpaceTime(getDateTime(temp), Double.valueOf(temp[1]), Double.valueOf(temp[2]), temp[4]);
	}

	private static LocalDateTime getDateTime(String[] input) {
		int day, month, year, hour, minute, second;
		int a = 0;
		int b = 3;
		if (input.length == 6) {
			a = 3;
			b = 0;
		}
		day = Integer.valueOf(input[a].substring(0, 2));
		month = Integer.valueOf(input[a].substring(2, 4));
		year = Integer.valueOf(input[a].substring(4, 8));
		hour = Integer.valueOf(input[b].substring(0, 2));
		minute = Integer.valueOf(input[b].substring(2, 4));
		second = Integer.valueOf(input[b].substring(4, 6));

		return LocalDateTime.of(year, month, day, hour, minute, second);
	}

	private static String[] stripAndExtract(String input) {
		StringBuffer buffer = new StringBuffer();
		for (char c : input.toCharArray()) {
			if (c != '(' && c != ')') {
				buffer.append(c);
			}
		}
		return buffer.toString().split(",");
	}

	@Override
	public String toString() {
		return "SpaceTime [dateTime=" + dateTime + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name
				+ "]";
	}
	
	
	
}
