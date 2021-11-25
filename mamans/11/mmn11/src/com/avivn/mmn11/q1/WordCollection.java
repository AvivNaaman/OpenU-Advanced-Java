package com.avivn.mmn11.q1;

import java.util.Random;

/**
 * Provides a dataset of random english words
 */
public class WordCollection {
    // The Collection of ALL the words that can be randomly chose
    private static final String[] wordSource = {
            "always",
            "answer",
            "base",
            "began",
            "begin",
            "between",
            "book",
            "both",
            "car",
            "care",
            "carry",
            "children",
            "city",
            "close",
            "color",
            "country",
            "cover",
            "cross",
            "cut",
            "don't",
            "draw",
            "ease",
            "eat",
            "example",
            "eye",
            "face",
            "far",
            "farm",
            "feet",
            "few",
            "fish",
            "food",
            "found",
            "four",
            "friend",
            "got",
            "group",
            "grow",
            "hard",
            "head",
            "hear",
            "horse",
            "idea",
            "keep",
            "last",
            "late",
            "learn",
            "left",
            "let",
            "letter",
            "life",
            "main",
            "mark",
            "might",
            "mile",
            "mountain",
            "music",
            "never",
            "next",
            "night",
            "north",
            "often",
            "once",
            "open",
            "own",
            "page",
            "paper",
            "plant",
            "press",
            "real",
            "river",
            "room",
            "run",
            "saw",
            "school",
            "science",
            "sea",
            "second",
            "seem",
            "should",
            "stand",
            "start",
            "state",
            "still",
            "stop",
            "story",
            "study",
            "sun",
            "sure",
            "those",
            "thought",
            "together",
            "took",
            "tree",
            "until",
            "walk",
            "watch",
            "while",
            "white",
            "wood"
    };

    /**
     * Picks a random alphanumeric word from the collection.
     * @return The picked word, lowered-case.
     */
    public static String GetRandomWord() {
        Random rnd = new Random();
        // pick a random index from the static list
        int index = rnd.nextInt(wordSource.length);
        return wordSource[index];
    }
}
