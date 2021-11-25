package com.avivn.mmn11.q1;

/**
 * Represents the data of a game instance for a single word and it's guesses,
 * and provides the game's logic for each word.
 */
public class GameWord {
    // the collection of chars to guess from - in this case alphanumeric
    private final String CHAR_DOMAIN = "abcdefghijklmnopqrstuvwxyz";

    // picked word to guess
    private final String pickedWord;
    // holds the unguessed chars as a string, initially including all the chars
    private String unguessedChars = CHAR_DOMAIN;

    /**
     * Initializes a new word to guess
     */
    public GameWord() {
        // randomly pick the word
        pickedWord = WordCollection.GetRandomWord();
    }

    /**
     * Gets the next guess char of the user and checks whether it's the next char to guess in the string.
     * If the guess was right, the next guess will be the next char in the string.
     *
     * @param nextGuess The next guess char of the user
     * @return Whether the guess was right
     */
    public boolean guessNext(char nextGuess) {
        // make lower case
        nextGuess = Character.toLowerCase(nextGuess);

        int indexInUnguessed = unguessedChars.indexOf(nextGuess);
        if (indexInUnguessed < 0) {
            return false; // invalid guess!
        }
        // remove the unguessed char: save to it's index (not including) and from the next (including)
        unguessedChars = unguessedChars.substring(0, indexInUnguessed)
                + unguessedChars.substring(indexInUnguessed+1);
        return true;
    }

    /**
     * @return a string with the chars that weren't guessed
     */
    public String getUnguessedChars() {
        return unguessedChars;
    }

    /**
     * @return the total number of guesses, made by the user
     */
    public int getGuessCount() {
        return 26 - unguessedChars.length();
    }

    /**
     * @return whether not all the chars of the string were already guessed.
     */
    public boolean isMoreToGuess() {
        // return whether all unguessed chars are not in the string
        for (int i = 0; i < unguessedChars.length(); i++) {
            // at least 1 char is not guessed in the string
            if (pickedWord.indexOf(unguessedChars.charAt(i)) >= 0)
                return true;
        }
        return false;
    }

    /**
     * @return the word, with dashes (_) instead of unguessed chars.
     */
    public String getDisplayString() {
        StringBuilder output = new StringBuilder();
        // Iterate word, replace appended char with _ if unguessed
        for (int i = 0; i < pickedWord.length(); i++) {
            char currChar = pickedWord.charAt(i);
            output.append(unguessedChars.indexOf(currChar) >= 0 ? '_' : currChar);
        }
        return output.toString();
    }
}
