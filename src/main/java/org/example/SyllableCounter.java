package org.example;

public class SyllableCounter {

    public static int countSyllables(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }

        word = word.toLowerCase().trim();
        int count = 0;
        boolean prevWasVowel = false;

        String vowels = "aeiouy";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isVowel = vowels.indexOf(c) >= 0;

            if (isVowel && !prevWasVowel) {
                count++;
            }

            prevWasVowel = isVowel;
        }

        // Subtract 1 if word ends with 'e' but not 'le' (common English rule)
        if (word.endsWith("e") && !word.endsWith("le") && count > 1) {
            count--;
        }

        return Math.max(count, 1); // At least one syllable
    }
}

