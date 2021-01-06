package testing;
/* Java game Guess a Number that allows user to guess a random number that has been generated.
*/
import javax.swing.*;
 
public class GuessingGame {
    public static void main(String[] args) {
    	
    	initializeGame();
    	
    }
    
    public static void initializeGame () {
    	int computerNumber = (int) (Math.random()*100 + 1);
        System.out.println("The correct guess would be " + computerNumber);

            JOptionPane.showMessageDialog(null, "Welcome to the guessing game!");

        boolean results = playGame(computerNumber);
        while (results == false)
        {
        	results = playGame(computerNumber);
        }
        JOptionPane.showMessageDialog(null, "You won, congratulations!");

    }
    public static boolean playGame (int computerNumber) {
    	int userAnswer = 0;

        {
           String response = JOptionPane.showInputDialog(null,
                "Enter a guess between 1 and 100", "Guessing Game", 3);
            System.out.println(response);
            
            if(response == null) {
            JOptionPane.showMessageDialog(null, ""+ "Goodbye!");
            throw new NumberFormatException();
            }
            
            Integer temp = tryParse(response);
            if(temp == null) {
                JOptionPane.showMessageDialog(null, ""+ determineOutcome(computerNumber, response));
                return false;
            } 
            else { 
            JOptionPane.showMessageDialog(null, ""+ determineOutcome(computerNumber, response));
            Integer answer = tryParse(response);
           if (answer == computerNumber) {
        	   return true;
           }
           return false;
            }
        }
    }
    
    public static String determineOutcome (int computerNumber, String response) {
    Integer answer = tryParse(response);
    if(answer == null) {
       return stringEasterEgg(response, computerNumber);
    }
    else {
    	return determineGuess(answer, computerNumber);
    }
    	
    }
    
    
    public static String stringEasterEgg(String naughtyPlayer, int answer) {
    	String newString = naughtyPlayer + "is not a number, you are being naughty... and I will punish you... by letting you win!"
    			+ "the correct answer is: " + answer;
    	return newString;
    }
    

    public static String determineGuess(int userAnswer, int computerNumber){
        System.out.println(userAnswer + " " + computerNumber);
        
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!";
        }
        else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: irrelevant";
        }
        else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: irrelevant ";
        }
        else {
            return "Your guess is incorrect";
        }
    }
    
    public static Integer tryParse(String text) {
    	  try {
    	    return Integer.parseInt(text);
    	  } catch (NumberFormatException e) {
    	    return null;
    	  }
    	}
}