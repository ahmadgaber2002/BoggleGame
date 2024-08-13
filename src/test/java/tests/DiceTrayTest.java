// Ahmad Gaber
package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import model.DiceTray;

public class DiceTrayTest {

	@Before
	public void init() {
		randomBoard1 = new DiceTray(randomChars);
		longWordBoard = new DiceTray(longWords);
		repeatablesBoard = new DiceTray(repeatables);
	}

	private char[][] randomChars = {

			{ 'R', 'E', 'D', 'M' },

			{ 'B', 'A', 'N', 'O' },

			{ 'T', 'Q', 'D', 'F' },

			{ 'L', 'O', 'E', 'V' } };

	private char[][] longWords = {

			{ 'A', 'B', 'S', 'E' },

			{ 'I', 'M', 'T', 'N' },

			{ 'N', 'D', 'E', 'D' },

			{ 'S', 'S', 'E', 'N' } };

	private char[][] repeatables = {

			{ 'M', 'O', 'S', 'E' },

			{ 'D', 'A', 'L', 'N' },

			{ 'T', 'O', 'P', 'D' },

			{ 'S', 'S', 'E', 'N' } };

	private DiceTray randomBoard1, longWordBoard, repeatablesBoard;

	public static String newline = "/n";

	private boolean searchBoard(DiceTray tray, String s) {
		return tray.found(s);
	}

	@Test
	public void test1() {
		assertFalse(searchBoard(randomBoard1, "REDD"));
		assertTrue(searchBoard(randomBoard1, "BAN"));
		assertTrue(searchBoard(randomBoard1, "red"));
		assertTrue(searchBoard(randomBoard1, "ban"));
	}

	@Test
	public void test2() {
		assertTrue(searchBoard(repeatablesBoard, "TOP"));
		assertTrue(searchBoard(repeatablesBoard, "LAD"));
		assertTrue(searchBoard(repeatablesBoard, "END"));
	}

	@Test
	public void test3() {
		assertTrue(searchBoard(repeatablesBoard, "top"));
		assertTrue(searchBoard(repeatablesBoard, "lad"));
		assertTrue(searchBoard(repeatablesBoard, "end"));
	}

	@Test
	public void test4() {
		assertTrue(searchBoard(repeatablesBoard, "SOLE"));
		assertTrue(searchBoard(randomBoard1, "TAD"));
	}

	@Test
	public void test5() {
		assertTrue(searchBoard(repeatablesBoard, "MAP"));
		assertTrue(searchBoard(randomBoard1, "RAD"));
	}

	@Test
	public void test6() {
		assertTrue(searchBoard(randomBoard1, "BAD"));
		assertTrue(searchBoard(randomBoard1, "TOE"));
		assertTrue(searchBoard(randomBoard1, "LOT"));
		assertTrue(searchBoard(randomBoard1, "ADO"));
		assertTrue(searchBoard(randomBoard1, "NAB"));
	}

	@Test
	public void test7() {
		assertTrue(searchBoard(randomBoard1, "LODE"));
	}

	@Test
	public void test8() {
		assertTrue(searchBoard(randomBoard1, "BaDe"));
		assertTrue(searchBoard(randomBoard1, "BEaD"));
		assertTrue(searchBoard(randomBoard1, "LoDe"));
		assertTrue(searchBoard(randomBoard1, "dODo"));
	}

	@Test
	public void test10() {
		assertTrue(searchBoard(longWordBoard, "ABS"));
		assertTrue(searchBoard(longWordBoard, "ABSENT"));
		assertTrue(searchBoard(longWordBoard, "ABSENTMIND"));
		assertTrue(searchBoard(longWordBoard, "ABSENTMINDED"));
	}

	@Test
	public void test11() {
		assertTrue(searchBoard(longWordBoard, "ABSENTMIND"));
		assertTrue(searchBoard(longWordBoard, "ABSENT"));
		assertTrue(searchBoard(longWordBoard, "ABS"));
	}

	@Test
	public void test12() {
		assertTrue(searchBoard(randomBoard1, "BEAR"));
		assertTrue(searchBoard(randomBoard1, "DARE"));
		assertTrue(searchBoard(randomBoard1, "BRAND"));
	}

	@Test
	public void test13() {
		assertTrue(searchBoard(randomBoard1, "RANDOM"));
		assertTrue(searchBoard(randomBoard1, "DANDER"));
		assertTrue(searchBoard(randomBoard1, "FOND"));
	}

	@Test
	public void test14() {
		assertTrue(searchBoard(longWordBoard, "ABSENTMINDED"));
		assertTrue(searchBoard(longWordBoard, "ABSENTMINDEDNESS"));
	}

	@Test
	public void test15() {
		assertFalse(searchBoard(repeatablesBoard, "DAD"));
		assertFalse(searchBoard(repeatablesBoard, "MOM"));
		assertFalse(searchBoard(repeatablesBoard, "POP"));
		assertFalse(searchBoard(repeatablesBoard, "TOT"));
		assertFalse(searchBoard(repeatablesBoard, "MOSS"));
	}

	@Test
	public void test16() {
		assertFalse(searchBoard(repeatablesBoard, "PIZZA"));
		assertFalse(searchBoard(repeatablesBoard, "PUDDING"));
		assertFalse(searchBoard(repeatablesBoard, "MACE"));
	}

	@Test
	public void test17() {
		assertFalse(searchBoard(repeatablesBoard, "ZEBRA"));
		assertFalse(searchBoard(repeatablesBoard, "BANANA"));
		assertFalse(searchBoard(repeatablesBoard, "CAT"));
		assertFalse(searchBoard(repeatablesBoard, "BAT"));
		assertFalse(searchBoard(repeatablesBoard, "BAD"));
	}

	@Test
	public void test18() {
		assertFalse(searchBoard(longWordBoard, "ABSENTMINDEDNESSES"));
	}

	private char[][] chars = {

			{ 'A', 'B', 'C', 'D' },

			{ 'E', 'F', 'G', 'H' },

			{ 'I', 'J', 'K', 'L' },

			{ 'M', 'N', 'O', 'P' }

	};

	@Test
	public void test19() {
		DiceTray b = new DiceTray(chars);
		assertTrue(b.found("ABC"));
		assertTrue(b.found("ABF"));
		assertTrue(b.found("ABCD"));

	}

	@Test
	public void test20() {
		DiceTray b = new DiceTray(chars);

		assertTrue(b.found("AEI"));
		assertTrue(b.found("AEIM"));
		assertTrue(b.found("AFK"));
		assertTrue(b.found("AFKP"));
	}

	@Test
	public void test21() {
		DiceTray b = new DiceTray(chars);

		assertTrue(b.found("AFK"));
		assertTrue(b.found("AFKP"));

		assertTrue(b.found("ABFEJINM"));
		assertTrue(b.found("ABEFIJMN"));
	}

	@Test
	public void test22() {
		DiceTray b = new DiceTray(chars);
		assertFalse(b.found("ACB"));
		assertFalse(b.found("AIE"));
		assertFalse(b.found("AKF"));
		assertFalse(b.found("AFGHP"));
	}

	@Test
	public void test23() {
		DiceTray b = new DiceTray(chars);
		assertFalse(b.found("ACA"));
		assertFalse(b.found("AEFBA"));
		assertFalse(b.found("POP"));
		assertFalse(b.found("LOL"));
	}

	@Test
	public void test24() {
		DiceTray b = new DiceTray(chars);
		assertFalse(b.found("KOK"));
		assertFalse(b.found("FGF"));
		assertFalse(b.found("ABA"));
		assertFalse(b.found("NON"));
	}

	@Test
	public void test25() {

		char[][] board = { { 'N', 'A', 'T', 'R' }, { 'E', 'E', 'E', 'E' }, { 'E', 'R', 'I', 'T' },
				{ 'S', 'Q', 'E', 'N' } };

		DiceTray test = new DiceTray(board);

		assertTrue(test.found("QUEEN"));
		assertTrue(test.found("QueeN"));
		assertTrue(test.found("qUeEN"));
		assertTrue(test.found("queEN"));
		assertTrue(test.found("quit"));
		assertTrue(test.found("QUit"));
		assertTrue(test.found("qUit"));
		assertTrue(test.found("Quit"));
		assertFalse(test.found("Qu"));

	}

	@Test
	public void testConstructor() {
		DiceTray diceTray = new DiceTray();
		assertTrue(diceTray.SIZE == 4);
//    assertTrue(randomBoard1.SIZE == 16);
	}

	@Test
	public void testToString() {
		assertTrue(randomBoard1.toString().contains("\n"));
	}

}