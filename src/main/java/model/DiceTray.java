// Ahmad Gaber
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DiceTray {
	private char[][] path;
	private char[][] board;
	public static final char VISITED = '*';
	private String attempt;
	private int index;
	public static final int SIZE = 4;
	public static final int SIDES_COUNT = 6;
	String[] dice = new String[] { "LRYTTE", "VTHRWE", "EGHWNE", "SEOTIS", "ANAEEG", "IDSYTT", "OATTOW", "MTOICU",
			"AFPKFS", "XLDERI", "HCPOAS", "ENSIEU", "YLDEVR", "ZNRNHL", "NMIQHU", "OBBAOJ" };
	private ArrayList<String> diceRandom;
	private static Random random;

	public DiceTray() {
		this.diceRandom = new ArrayList();

		for (int die = 0; die < 16; ++die) {
			this.diceRandom.add(this.dice[die]);
		}

		random = new Random();
		this.board = this.getRandomizedDiceArray();
	}

	public DiceTray(char[][] newBoard) {
		this.board = newBoard;
	}

	public String toString() {
		String result = "";

		for (int r = 0; r < 4; ++r) {
			result = result + "\n";

			for (int c = 0; c < 4; ++c) {
				if (this.board[r][c] == 'Q') {
					result = result + " Qu";
				} else {
					result = result + "  " + this.board[r][c];
				}
			}

			if (r < 3) {
				result = result + " \n";
			}
		}

		return result;
	}

	private char[][] getRandomizedDiceArray() {
		char[][] randomBoard = new char[4][4];
		Collections.shuffle(this.diceRandom);
		int dieNumber = 0;

		for (int r = 0; r < 4; ++r) {
			for (int c = 0; c < 4; ++c) {
				String s = (String) this.diceRandom.get(dieNumber);
				char letterToPlace = s.charAt(random.nextInt(6));
				randomBoard[r][c] = letterToPlace;
				++dieNumber;
			}
		}

		return randomBoard;
	}

	public boolean found(String word) {
		if (word.length() < 3) {
			return false;
		} else {
			this.attempt = word.toUpperCase().trim();
			boolean found = false;

			for (int r = 0; r < 4; ++r) {
				for (int c = 0; c < 4; ++c) {
					if (this.board[r][c] == this.attempt.charAt(0)) {
						this.init();
						found = this.recursiveFind(r, c);
						if (found) {
							return true;
						}
					}
				}
			}

			return found;
		}
	}

	private void init() {
		this.path = new char[4][4];

		for (int r = 0; r < 4; ++r) {
			for (int c = 0; c < 4; ++c) {
				this.path[r][c] = '.';
			}
		}

		this.index = 0;
	}

	private boolean recursiveFind(int r, int c) {
		boolean found = false;
		if (this.valid(r, c)) {
			this.path[r][c] = '*';
			if (this.board[r][c] == 'Q') {
				this.index += 2;
			} else {
				++this.index;
			}

			if (this.index >= this.attempt.length()) {
				found = true;
			} else {
				found = this.recursiveFind(r - 1, c - 1);
				if (!found) {
					found = this.recursiveFind(r - 1, c);
				}

				if (!found) {
					found = this.recursiveFind(r - 1, c + 1);
				}

				if (!found) {
					found = this.recursiveFind(r, c - 1);
				}

				if (!found) {
					found = this.recursiveFind(r, c + 1);
				}

				if (!found) {
					found = this.recursiveFind(r + 1, c - 1);
				}

				if (!found) {
					found = this.recursiveFind(r + 1, c);
				}

				if (!found) {
					found = this.recursiveFind(r + 1, c + 1);
				}

				if (!found) {
					this.path[r][c] = '.';
					--this.index;
				}
			}
		}

		return found;
	}

	private boolean valid(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4 && this.path[r][c] != '*'
				&& this.board[r][c] == this.attempt.charAt(this.index);
	}
}
