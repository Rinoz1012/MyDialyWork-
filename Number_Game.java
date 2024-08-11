/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.number_game;

/**
 *
 * @author user
 */
import java.util.Scanner;
public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lower = 1, upper = 100;
        int secretNumber, userGuess, attempts = 0, rounds = 0;
        boolean guessedCorrectly;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("I've picked a number between %d and %d. Try to guess it!\n", lower, upper);

        do {
            // Generate a new secret number for each round
            secretNumber = (int) (Math.random() * (upper - lower + 1)) + lower;
            guessedCorrectly = false;
            attempts = 0;
            rounds++;

            while (!guessedCorrectly && attempts < 10) { // Limit to 10 attempts per round
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.printf("Congratulations! You guessed the correct number in %d attempts.\n", attempts);
                    guessedCorrectly = true;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            System.out.print("Play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        // Display user's score (rounds won)
        System.out.printf("You played %d rounds. Thanks for playing!\n", rounds);

    }
}
