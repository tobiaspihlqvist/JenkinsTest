package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class GuessingGameDetermineGuessTest {
	@Test
	public void testDetermineGuess_correct_answer() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(20, 20, 1);
		assertTrue(stringResult == "Correct!");
	}
	
	@Test
	public void testDetermineGuess_userInput_upper_upper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(101, 20, 1);
		assertTrue(stringResult == "Your guess is invalid");
	}
	@Test
	public void testDetermineGuess_userInput_lower_upper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(2, 20, 1);
		assertTrue(stringResult.contains("Your guess is too low"));
	}
	
	@Test
	public void testDetermineGuess_userInput_upper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(99, 20, 1);
		assertTrue(stringResult.contains("Your guess is too high"));
	}
	@Test
	public void testDetermineGuess_userInput_lower_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(0, 20, 1);
		assertTrue(stringResult == "Your guess is invalid");
	}
	
	@Test
	public void testDetermineGuess_userInput_AllowedUpper_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(100, 20, 1);
		assertTrue(stringResult.contains("Your guess is too high"));
	}
	
	@Test
	public void testDetermineGuess_userInput_AllowedLower_boundary() {
		GuessingGame game = new GuessingGame();
		String stringResult = game.determineGuess(1, 20, 1);
		assertTrue(stringResult.contains("Your guess is too low"));
	}
}
