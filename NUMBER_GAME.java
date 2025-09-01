import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NUMBER_GAME{
	    int Min = 1;
	    private static final int Max = 100;
	    private static final int Attempts = 8;
	    
	    private Scanner obj;
	    private Random random;
	    private int roundsWon;

	    public NUMBER_GAME() {
	        this.obj = new Scanner(System.in);
	        this.random = new Random();
	        this.roundsWon = 0;
	    }

	    public void startGame() {
	        System.out.println("Guess a number between " + Min + " and " + Max + ".");
	        System.out.println("You have " + Attempts + " attempts to guess.");

	        boolean playAgain;
	        do {
	            playRound();
	            System.out.print("Do you want to play another round? (yes/no): ");
	            String playAgainInput = obj.nextLine().trim().toLowerCase();
	            playAgain = playAgainInput.startsWith("y");
	        } while (playAgain);

	        displayFinalScore();
	        obj.close();
	        System.out.println("\nThank you for playing. Goodbye!");
	    }

	    private void playRound() {
	        int targetNumber = random.nextInt(Max - Min + 1) + Min;
	        int attempts = 0;
	        boolean hasGuessedCorrectly = false;

	        while (attempts < Attempts && !hasGuessedCorrectly) {
	            System.out.println(" Attempt " + (attempts + 1) + " of " + Attempts);
	            int userGuess = getValidGuess();
	            if (userGuess == targetNumber) {
	                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
	                System.out.println("You took " + (attempts + 1) + " attempts to win this round.");
	                roundsWon++;
	                hasGuessedCorrectly = true;
	            } else if (userGuess > targetNumber) {
	                System.out.println("Your guess is too high. Try a lower number.");
	            } else {
	                System.out.println("Your guess is too low. Try a higher number.");
	            }
	            attempts++;
	        }

	        if (!hasGuessedCorrectly) {
	            System.out.println("\nGame over. No more attempts!");
	            System.out.println("The number was: " + targetNumber);
	        }
	    }

	    private int getValidGuess() {
	        while (true) {
	            System.out.print("Enter your guess: ");
	            try {
	                int num = obj.nextInt();
	                obj.nextLine();
	                if (num >= Min && num <= Max) {
	                    return num;
	                } else {
	                    System.out.println("Please enter a number between " + Min + " and " + Max + ".");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input.");
	                obj.nextLine();
	            }
	        }
	    }

	    private void displayFinalScore() {
	    	System.out.println("RESULT\n");
	        System.out.println("Rounds Won: " + roundsWon);
	        System.out.println("THANK YOU! DO PLAY AGAIN");
	    }
	    
	    public static void main(String[] args) {
	    	NUMBER_GAME game = new NUMBER_GAME();
	        game.startGame();
	    }
	}
