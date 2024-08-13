// Ahmad Gaber
package views;

import java.util.Scanner;

import model.Boggle;

public class BoggleConsole {
	private static Boggle game = new Boggle();

	public static void main(String[] args) {
		System.out.println("Welcome to Boggle Console Game");
		System.out.println(game.getBoardString());
		System.out.println();
		System.out.println("Enter a word you see on the DiceTray or enter \"X \"or \"x\" to quit");
		System.out.println();
		Scanner reader = new Scanner(System.in);
		while (true) {
			String words = reader.nextLine();
			if (words.equalsIgnoreCase("X")) {
				System.out.println(game.getResults());
				break;
			}

			String[] wordsArr = words.split(" ");
			for (int i = 0; i < wordsArr.length; i++) {
				String word = wordsArr[i];
				game.processGuess(word);
			}
		}
	}
}