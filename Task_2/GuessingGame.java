import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    boolean playAgain = true;
    int totalGames = 0;
    int totalWins = 0;
    int totalScore = 0;

    System.out.println("\n============================= Welcome to the Guessing Game =============================");

    while (playAgain) {
      System.out.println("\nChoose Difficulty Level:");
      System.out.println("1. Easy (1 to 50)");
      System.out.println("2. Medium (1 to 100)");
      System.out.println("3. Hard (1 to 500)");
      System.out.print("Enter choice (1/2/3): ");

      int choice = sc.nextInt();
      int upperLimit;

      switch (choice) {
        case 1 -> upperLimit = 50;
        case 2 -> upperLimit = 100;
        case 3 -> upperLimit = 500;
        default -> {
          System.out.println("Invalid choice! Defaulting to Medium (1 to 100).");
          upperLimit = 100;
        }
      }

      int numberToGuess = random.nextInt(upperLimit) + 1;
      int userGuess = 0;
      int attempts = 0;
      final int MAX_ATTEMPTS = 3; // now only 3 attempts

      System.out.println("\nI have generated a number between 1 and " + upperLimit + ".");
      System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

      boolean guessedCorrectly = false;

      while (attempts < MAX_ATTEMPTS) {
        System.out.print("\nEnter your guess: ");
        userGuess = sc.nextInt();
        attempts++;

        if (userGuess == numberToGuess) {
          System.out.println("Congratulations! You guessed the number " + numberToGuess);
          System.out.println("Attempts taken: " + attempts);

          // Scoring: fewer attempts = more points
          int score = (MAX_ATTEMPTS - attempts + 1) * 10;
          totalScore += score;
          System.out.println("You earned " + score + " points.");

          guessedCorrectly = true;
          totalWins++;
          break;
        } else {
          if (Math.abs(userGuess - numberToGuess) <= 5) {
            System.out.println("Very close! Try again.");
          } else if (userGuess < numberToGuess) {
            System.out.println("Too low! Try again.");
          } else {
            System.out.println("Too high! Try again.");
          }
          System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
        }
      }

      if (!guessedCorrectly) {
        System.out.println("\nSorry! You've used all attempts.");
        System.out.println("The correct number was: " + numberToGuess);
      }

      totalGames++;
      System.out.println("\nGame Summary:");
      System.out.println("   Games played: " + totalGames);
      System.out.println("   Games won: " + totalWins);
      System.out.println("   Total score: " + totalScore + " points");

      System.out.print("\nDo you want to play again? (yes/no): ");
      String response = sc.next();
      playAgain = response.equalsIgnoreCase("yes");
    }

    System.out.println("\nThanks for playing the Guessing Game!\n");
    System.out.println("Final Stats:");
    System.out.println("   Games played: " + totalGames);
    System.out.println("   Games won: " + totalWins);
    System.out.println("   Total score: " + totalScore + " points");
    System.out.println("   Accuracy: " + (totalGames > 0 ? (totalWins * 100 / totalGames) : 0) + "%");

    sc.close();
  }
}
