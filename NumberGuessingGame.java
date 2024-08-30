package O;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 3; // Total number of rounds
        int score = 0;  // Player's score

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);

            int targetNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 5; // Number of attempts allowed
            int previousGuess = -1; // To track the previous guess for hinting

            System.out.println("I'm thinking of a number between 1 and 100. You have " + attempts + " attempts to guess it.");

            boolean guessedCorrectly = false; // Flag to check if the user guessed correctly

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    score++;
                    guessedCorrectly = true; // Set flag to true if guessed correctly
                    break; // Exit the loop since the user guessed correctly
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    System.out.println("Your guess is higher than the target number.");
                }

                // Provide hints based on proximity to the target number
                if (previousGuess != -1) {
                    if (Math.abs(targetNumber - guess) < Math.abs(targetNumber - previousGuess)) {
                        System.out.println("You're getting warmer!");
                    } else {
                        System.out.println("You're getting colder!");
                    }
                }

                previousGuess = guess; // Update previous guess
                attempts--;
                if (attempts > 0) {
                    System.out.println("You have " + attempts + " attempts left.");
                } else {
                    System.out.println("Sorry, you ran out of attempts. The target number was " + targetNumber + ".");
                }
            }

            // Display the correct answer if not guessed correctly
            if (!guessedCorrectly) {
                System.out.println("The correct answer was: " + targetNumber);
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your final score is " + score + " out of " + rounds + ".");

        scanner.close(); // Close the scanner
    }
}
