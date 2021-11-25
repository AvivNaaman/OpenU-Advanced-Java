package com.avivn.mmn11.q1;

import java.util.Scanner;

/**
 * Runs the word guessing
 */
public class Game {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the game interface
     */
    public void start() {
        do {
            playSingleWord();
            System.out.print("Would you like to play another game [y]? ");
        } while (Character.toLowerCase(scanner.next().charAt(0)) == 'y'); // continue if y/Y
    }

    // Handles the game UI for a single word
    private void playSingleWord() {
        // logic is mostly in GameWord - Randomizing and scanning.
        GameWord word = new GameWord();
        while (true) {
            System.out.print("Guess a char, then press enter: ");
            char guess = Character.toLowerCase(scanner.next().charAt(0));
            // check a-z/A-Z
            if (!Character.isAlphabetic(guess)) {
                System.out.println("Not an alphabetical char.");
            }

            // guess, if invalid (guessNext returns false) show error
            if (!word.guessNext(guess)) {
                System.out.println("Char already guessed!");
            }
            System.out.println(word.getDisplayString());

            // print available chars/exit if finished guessing
            if (word.isMoreToGuess())
                System.out.println(word.getUnguessedChars());
            else break;
        }
        // print end message
        System.out.printf("Word guessed in %d guesses.%n", word.getGuessCount());
    }
}
