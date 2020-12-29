package exercises.textparsing;

import javax.swing.JOptionPane;

public class WordSearch2 {

	public static void main(String[] args) {
		String text = "Audrey Hepburn may have looked like she lived the perfect Hollywood dream but according to a new documentary, behind the camera, she had a troubled life.";

		countOccurences(text);
	}

	public static void countOccurences(String text) {
		text = text.toLowerCase();
		String input = JOptionPane.showInputDialog("Enter search phrase ...").toLowerCase();
		String toBeTested = "";
		int count = 0;

		// Input validation:

		while (input.isBlank() || !isAlphanumeric(input.charAt(0)) || !isAlphanumeric(input.charAt(input.length() - 1))) {
			if (input.isBlank()) {
				input = JOptionPane.showInputDialog("No input: Please enter a word or character.").toLowerCase();
				continue;
			}
			input = JOptionPane.showInputDialog("Invalid input: No spaces or non-alphanumeric characters allowed!").toLowerCase();
		}

		// Parsing logic:

		A: for (int i = 0; i < text.length(); i++) {
			if (!isAlphanumeric(text.charAt(i))) {
				continue;
			}
			toBeTested += text.charAt(i);

			if (i != text.length() - 1) {
				if (isAlphanumeric(text.charAt(i + 1))) {
					continue;
				}
			}
			if (toBeTested.length() != input.length()) {
				toBeTested = "";
				continue;
			} else {
				for (int j = 0; j < input.length(); j++) {
					if (toBeTested.charAt(j) != input.charAt(j)) {
						toBeTested = "";
						continue A;
					}
					if (j == input.length() - 1) {
						toBeTested = "";
						count++;
					}
				}
			}
		}

		// Output:

		String msg = String.format("The number of occurrences for '%s' is '%d'", input, count);
		JOptionPane.showMessageDialog(null, msg);
	}

	private static boolean isAlphanumeric(char c) {
		switch (c) {
		case ' ':
		case ',':
		case '.':
		case ':':
		case ';':
			return false;
		default:
			return true;
		}
	}
}
