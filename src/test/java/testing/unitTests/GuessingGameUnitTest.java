package testing.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import testing.GuessingGame;

public class GuessingGameUnitTest {

	@Test
	public void testDetermineGuess_correct_answer() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(20, 20);
		assertTrue(stringResult == "Correct!");
	}
	
	@Test
	public void testDetermineGuess_userInput_upper_upper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(101, 20);
		assertTrue(stringResult == "Your guess is invalid");
	}
	@Test
	public void testDetermineGuess_userInput_lower_upper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(2, 20);
		assertTrue(stringResult.contains("Your guess is too low"));
	}
	
	@Test
	public void testDetermineGuess_userInput_upper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(99, 20);
		assertTrue(stringResult.contains("Your guess is too high"));
	}
	@Test
	public void testDetermineGuess_userInput_lower_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(0, 20);
		assertTrue(stringResult == "Your guess is invalid");
	}
	
	@Test
	public void testDetermineGuess_userInput_AllowedUpper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(100, 20);
		assertTrue(stringResult.contains("Your guess is too high"));
	}
	
	@Test
	public void testDetermineGuess_userInput_AllowedLower_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(1, 20);
		assertTrue(stringResult.contains("Your guess is too low"));
	}
@Test
public void testStringEasterEgg_expected_return() {
	GuessingGame game = new GuessingGame();
	String naughtyPlayer = "string";
	int answer = 2;

	assertEquals(game.stringEasterEgg("string", 2), naughtyPlayer + "is not a number, you are being naughty... and I will punish you... by letting you win!"
    			+ "the correct answer is: " + answer);
}

@Test
public void testTry_parse_is_integer() {
	GuessingGame game = new GuessingGame();
	assertTrue(game.tryParse("2") == 2);
}

@Test
public void testTry_parse_is_not_integer() {
	GuessingGame game = new GuessingGame();
	assertTrue(game.tryParse("no int") == null);
}
}
