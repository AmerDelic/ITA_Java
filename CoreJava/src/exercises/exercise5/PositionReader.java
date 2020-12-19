package exercises.exercise5;

import java.util.ArrayList;
import java.util.List;

public class PositionReader {
	
	public List<UserPosition> readPosition(String input) {
		List<String[]> posData = parse(input);
		List<UserPosition> positions = new ArrayList<UserPosition>();
		for (String[] pos : posData) {
			int i = 0;
			int id = Integer.valueOf(pos[i++]);
			double x = Double.valueOf(pos[i++]);
			double y = Double.valueOf(pos[i]);
			UserPoint uPoint = new UserPoint(x, y);
			UserPosition uPos = new UserPosition(id, uPoint);
			positions.add(uPos);
		}
		return positions;
	}

	private List<String[]> parse(String input) {
		List<String[]> posData = new ArrayList<String[]>();
		int from = 0;
		int to = 0;
		String temp = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '{') {
				from = i + 1;
			}
			if (input.charAt(i) == '}') {
				to = i;
				temp = input.substring(from, to);
				String[] output = extractValues(temp);
				if (output.length == 3) {
					posData.add(output);
				}
			}
		}
		return posData;
	}

	private String[] extractValues(String raw) {
		String temp = "";
		for (int i = 0; i < raw.length(); i++) {
			if (isValue(raw.charAt(i))) {
				temp += raw.charAt(i);
			}
		}
		return temp.split(",");
	}

	private boolean isValue(char c) {
		switch (c) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case ',':
			return true;
		default:
			return false;
		}
	}
}
