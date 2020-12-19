package exercises.exercise1;

import javax.swing.JOptionPane;

public class WordSearch3 {
	public static void main(String[] args) {
		String text = "Audrey Hepburn may have looked like she lived the perfect Hollywood dream but according to a new documentary, behind the camera, she had a troubled life.";

		countOccurences(text);
	}

	public static void countOccurences(String text) {
		char[] textArr = text.toLowerCase().toCharArray();
		char[] input = JOptionPane.showInputDialog("Enter search phrase ...").toLowerCase().toCharArray();
		int count = 0;

		// Input validation:

		while (input.length == 0 || !isAlphanumeric(input[0]) || !isAlphanumeric(input[input.length - 1])) {
			if (input.length == 0) {
				input = JOptionPane.showInputDialog("No input: Please enter a word or character.").toLowerCase().toCharArray();
				continue;
			}
			input = JOptionPane.showInputDialog("Invalid input: No spaces or non-alphanumeric characters allowed!")
					.toLowerCase().toCharArray();
		}

		// Parsing logic:

		A: for (int i = 0; i < textArr.length; i++) {
			if (!isAlphanumeric(textArr[i])) {
				continue;
			} else {
				B: for (int j = 0; j < input.length; j++) {
					if (textArr[i] != input[j]) {
						continue A;
					}
					if (i != textArr.length - 1 && !isAlphanumeric(textArr[i + 1]) && j == input.length - 1) {
						count++;
						continue A;
					} else {
						i++;
						continue B;
					}
				}
			}
		}

		// Output:
		
		String inputMsg = "";
		for(char c : input) {
			inputMsg += c;
		}
		String msg = String.format("The number of occurrences for '%s' is '%d'", inputMsg, count);
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
