import java.util.Random;
import java.util.Scanner;

    public class NumberGuessingGame {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int minRange = 1;
            int maxRange = 100;
            int maxAttempts = 10;
            int score = 0;

            System.out.println("Welcome to the Number Guessing Game!");

            do {
                int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ". Try to guess it!");

                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                    int userGuess = scanner.nextInt();

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                        guessedCorrectly = true;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }

                    attempts++;
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                } else {
                    score++;
                }

                System.out.print("Do you want to play again? (yes/no): ");
            } while (scanner.next().equalsIgnoreCase("yes"));

            System.out.println("Thanks for playing! Your total score is: " + score);

            scanner.close();
        }
    }


