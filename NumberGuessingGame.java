import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static final int MAX_ATTEMPTS = 5;
    static final int LOWER_BOUND = 1;
    static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            int target = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🕹️ New Round! Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND);
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess;

                // Check if input is valid number
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < target) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all your attempts. The number was: " + target);
            }

            totalRounds++;

            System.out.print("🎮 Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.startsWith("y");
        }

        // Display final score
        System.out.println("\n🏁 Game Over!");
        System.out.println("Rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
