// Ahmad Gaber
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Boggle;
import model.DiceTray;

public class BoggleTest {
	private Boggle randomBoggle, longBoggle, repeatBoggle;
	private DiceTray diceTray;

	@Before
	public void setUp() {

		randomBoard = new DiceTray(randomChars);
		longWordBoard = new DiceTray(longWords);
		repeatablesBoard = new DiceTray(repeatables);

		randomBoggle = new Boggle();
		randomBoggle.setBoggleTray(randomBoard);

		longBoggle = new Boggle();
		longBoggle.setBoggleTray(longWordBoard);

		repeatBoggle = new Boggle();
		repeatBoggle.setBoggleTray(repeatablesBoard);

	}

	private DiceTray randomBoard, longWordBoard, repeatablesBoard;

	public static String newline = "/n";
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

	@Test
	public void testGetBoardString() {
		assertNotNull(randomBoggle.getBoardString());
	}

	@Test
	public void testScoreOf() {

		assertEquals(0, randomBoggle.getScore());
		randomBoggle.processGuess("re");
		assertEquals(0, randomBoggle.getScore());
		randomBoggle.processGuess("red");
		randomBoggle.processGuess("red");
		assertEquals(1, randomBoggle.getScore());
		randomBoggle.processGuess("ban");
		assertEquals(2, randomBoggle.getScore());
		randomBoggle.processGuess("bed");
		assertEquals(3, randomBoggle.getScore());

		assertNotNull(randomBoggle.getResults());
	}

	@Test
	public void testProcessGuessCorrectWords() {
		randomBoggle.processGuess("red");
		assertEquals(1, randomBoggle.getCorrectWords().size());
		randomBoggle.processGuess("ban");
		assertEquals(2, randomBoggle.getCorrectWords().size());
		randomBoggle.processGuess("bed");
		assertEquals(3, randomBoggle.getCorrectWords().size());
		randomBoggle.processGuess("band");
		assertEquals(4, randomBoggle.getCorrectWords().size());
		assertTrue(randomBoggle.getCorrectWords().contains("band"));
		assertEquals("ban", randomBoggle.getCorrectWords().get(0));

	}

	@Test
	public void testProcessGuessWrongWords() {
		randomBoggle.processGuess("redd");
		assertEquals(1, randomBoggle.getWrongWords().size());
		randomBoggle.processGuess("bandd");
		assertEquals(2, randomBoggle.getWrongWords().size());
		randomBoggle.processGuess("bedd");
		assertEquals(3, randomBoggle.getWrongWords().size());
		assertTrue(randomBoggle.getWrongWords().contains("bandd"));
		assertEquals("bandd", randomBoggle.getWrongWords().get(0));

		assertNotNull(randomBoggle.getResults());

		randomBoggle.processGuess("Bear");
		assertEquals(1, randomBoggle.getScore());
		randomBoggle.processGuess("Dare");
		assertEquals(2, randomBoggle.getScore());
		randomBoggle.processGuess("Brand");
		assertEquals(4, randomBoggle.getScore());

	}

	@Test
	public void testProcessGuessWrongWords2() {
		assertEquals(0, repeatBoggle.getScore());
		repeatBoggle.processGuess("sandlot");
	}

	// Long Words

	@Test
	public void testScoreOfLongWords() {
		assertEquals(0, longBoggle.getScore());
		longBoggle.processGuess("ABSENT");
		assertEquals(3, longBoggle.getScore());
		longBoggle.processGuess("ABSENTMIND");
		assertEquals(3, longBoggle.getScore());
		longBoggle.processGuess("ABSENTMINDED");
		assertEquals(14, longBoggle.getScore());

	}

	@Test
	public void testProcessGuessCorrectWordsLongWords() {
		longBoggle.processGuess("red");
//		assertEquals(1, longBoggle.getCorrectWords().size());
//		longBoggle.processGuess("ban");
//		assertEquals(2, longBoggle.getCorrectWords().size());
//		longBoggle.processGuess("bed");
//		assertEquals(3, longBoggle.getCorrectWords().size());
//		longBoggle.processGuess("band");
//		assertEquals(4, longBoggle.getCorrectWords().size());
//		assertTrue(longBoggle.getCorrectWords().contains("band"));
//		assertEquals("ban", longBoggle.getCorrectWords().get(0));
	}

	@Test
	public void testProcessGuessWrongWordsLongWords() {
		longBoggle.processGuess("redd");
		assertEquals(1, longBoggle.getWrongWords().size());
		longBoggle.processGuess("bandd");
		assertEquals(2, longBoggle.getWrongWords().size());
		longBoggle.processGuess("bedd");
		assertEquals(3, longBoggle.getWrongWords().size());
		assertTrue(longBoggle.getWrongWords().contains("bandd"));
		assertEquals("bandd", longBoggle.getWrongWords().get(0));

	}

	@Test
	public void testProcessNotGuessedWords() {
		randomBoggle.processGuess("red");
		randomBoggle.processGuess("band");
		randomBoggle.processGuess("bed");
		assertEquals(87, randomBoggle.getNotGuessedWords().size());
	}

	@Test
	public void testGetNotGuessedWords1() {
		Boggle boggle = new Boggle();
		List<String> notGuessed = boggle.getNotGuessedWords();
		assertNotNull(notGuessed);
	}

	@Test
	public void testGetScore() {
		randomBoggle.processGuess("abc");
		assertEquals(0, randomBoggle.getScore());

		randomBoggle.processGuess("abcd");
		assertEquals(0, randomBoggle.getScore());

		randomBoggle.processGuess("efg");
		assertEquals(0, randomBoggle.getScore());
	}

	@Test
	public void testGetResults() {
		Boggle boggle = new Boggle();
		String results = boggle.getResults();
		assertNotNull(results);
		assertTrue(results.startsWith("Your score: 0"));
	}

	@Test
	public void testSetBoggleTray() {
		Boggle boggle = new Boggle();
		DiceTray diceTray = new DiceTray();
		boggle.setBoggleTray(diceTray);
	}

	@Test
	public void testGetCorrectWords() {
		Boggle boggle = new Boggle();
		List<String> correctWords = boggle.getCorrectWords();
		assertEquals(0, correctWords.size());
	}

	@Test
	public void testGetWrongWords() {
		Boggle boggle = new Boggle();
		List<String> wrongWords = boggle.getWrongWords();
		assertEquals(0, wrongWords.size());
	}

}