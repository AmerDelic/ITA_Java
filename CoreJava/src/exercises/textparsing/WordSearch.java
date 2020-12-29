package exercises.textparsing;

import javax.swing.JOptionPane;


public class WordSearch {

	public static void main(String[] args) {

		String text = "Audrey Hepburn may have looked like she lived the perfect Hollywood dream but according to a new documentary, behind the camera, she had a troubled life.";

		countOccurences(text);
	}

	public static void countOccurences(String text) {
		String input = JOptionPane.showInputDialog("Enter search phrase ...").toLowerCase();
		String toBeTested = "";
		int count = 0;
		int fromIndex = 0;

		while (input.isBlank() || ((input.charAt(0) == ' ') || input.charAt(input.length() - 1) == ' ')) {
			if (input.isBlank()) {
				input = JOptionPane.showInputDialog("No input: Please enter a word or character.").toLowerCase();
				continue;
			}
			input = JOptionPane.showInputDialog("Invalid input: No spaces allowed!").toLowerCase();
		}

		A: for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				toBeTested = text.substring(fromIndex, i).toLowerCase();
				fromIndex = i + 1;
				for (int j = 0; j < toBeTested.length(); j++) {
					if (input.length() != toBeTested.length()) {
						continue A;
					} else if (input.charAt(j) != toBeTested.charAt(j)) {
						continue A;
					} else if (j == toBeTested.length() - 1) {
						count++;
					}
				}
			}
		}
		String msg = String.format("The number of occurrences for '%s' is '%d'", input, count);
		JOptionPane.showMessageDialog(null, msg);
	}

}
