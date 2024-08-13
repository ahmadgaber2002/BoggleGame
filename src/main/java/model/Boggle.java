//Ahmad Gaber
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boggle {

	private DiceTray diceTray;

	private ArrayList<String> dictionaryWords;

	private ArrayList<String> wrongWords;

	private ArrayList<String> correctWords;

	private static final int MIN_WORD_LENGTH = 3, MAX_WORD_LENGTH = 16;

	public Boggle() {
		wrongWords = new ArrayList<>();
		diceTray = new DiceTray();
		correctWords = new ArrayList<>();
		loadDictionary("BoggleWords.txt");
	}

	public void setBoggleTray(DiceTray dt) {
		this.diceTray = dt;
	}

	public String getBoardString() {
		return diceTray.toString();
	}

	private int scoreOf(String next) {
		if (next.length() == 3)
			return 1;
		if (next.length() == 4)
			return 1;
		if (next.length() == 5)
			return 2;
		if (next.length() == 6)
			return 3;
		if (next.length() == 7)
			return 5;
		return 11;
	}

	private void loadDictionary(String fileName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
		}

		dictionaryWords = new ArrayList<>();
		while (scanner.hasNext()) {
			String word = scanner.next().trim();
			// Add only words of length between 3 and 16 characters
			if (word.length() >= MIN_WORD_LENGTH && word.length() <= MAX_WORD_LENGTH)
				dictionaryWords.add(word);
		}
	}

	public void processGuess(String guess) {
		guess = guess.toLowerCase().trim();
		if (guess.length() < MIN_WORD_LENGTH || guess.length() > MAX_WORD_LENGTH)
			return;
		if (wrongWords.contains(guess) || correctWords.contains(guess))
			return;
		if (diceTray.found(guess) && Collections.binarySearch(dictionaryWords, guess) >= 0)
			correctWords.add(guess);
		else
			wrongWords.add(guess);
	}

	public int getScore() {
		int score = 0;
		for (String word : correctWords) {
			score += this.scoreOf(word);
		}
		return score;
	}

	public List<String> getNotGuessedWords() {
		List<String> notGuessed = new ArrayList<>();

		for (String word : dictionaryWords) {
			if (!correctWords.contains(word) && this.diceTray.found(word)) {
				notGuessed.add(word);
			}
		}
		Collections.sort(notGuessed);
		return notGuessed;
	}

	public List<String> getCorrectWords() {
		Collections.sort(correctWords);
		return correctWords;
	}

	public List<String> getWrongWords() {
		Collections.sort(wrongWords);
		return wrongWords;
	}

	public String getResults() {
		int index;
		String results = "Your score: " + this.getScore() + "\n\n" + "Words you found:" + "\n";

		List<String> wordsFound = this.getCorrectWords();
		for (index = 0; index < wordsFound.size(); index++) {
			results += (wordsFound.get(index) + " ");
		}

		results += "\n\nIncorrect words" + "\n";
		List<String> incorrectWords = this.getWrongWords();
		for (index = 0; index < incorrectWords.size(); index++) {
			results += (incorrectWords.get(index) + " ");

		}

		List<String> wordsNotGuessed = this.getNotGuessedWords();
		results += "\n\nYou could have found " + (wordsNotGuessed.size()) + " more words:\n";
		for (index = 0; index < wordsNotGuessed.size(); index++) {
			results += (wordsNotGuessed.get(index) + " ");
		}

		return results;
	}

}