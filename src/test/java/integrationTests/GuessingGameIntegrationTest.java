package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import testing.GuessingGame;

public class GuessingGameIntegrationTest {

	@Test
	public void test_determineOutcome_returns_empty() {
		
		GuessingGame game = new GuessingGame();
		String emptyString = game.determineOutcome(2, "not empty");
		
		assertFalse(emptyString == "");
	}
	
	@Test
	public void test_determineOutcome_returns_faultyInputMessage() {
		
		GuessingGame game = new GuessingGame();
		String faultyinputString = game.determineOutcome(2, "faulty");
		assertTrue(faultyinputString.contains("is not a number, you are being naughty... and I will punish you... by letting you win!"));
	}
	
	
	@Test
	public void test_determineOutcome_returns_winning_input() {
		GuessingGame game = new GuessingGame();
		String winningString = game.determineOutcome(2, "2");
		assertTrue(winningString == "Correct!");
	}
}
