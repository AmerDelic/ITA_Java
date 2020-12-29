package exercises.spacetime;

import java.time.LocalDateTime;

// Exercise: create a class to represent a user's position in space and time.
// Create a method which accepts a string and extracts the values of dateTime, latitude, longitude, and name.
// Input string format: (22052014,44.756364,20.412598,051230,123143124122)
// or, if the date and time parts switch position, there is an additional 'H', like so:
// (051230,44.756364,20.412598,22052014,123143124122,H).

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
