package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SyllableCounterTest {

    @Test
    void testSingleSyllable() {
        assertEquals(1, SyllableCounter.countSyllables("cat"));
    }

    @Test
    void testMultipleSyllables() {
        assertEquals(3, SyllableCounter.countSyllables("elephant"));
    }

    @Test
    void testSilentE() {
        assertEquals(1, SyllableCounter.countSyllables("the"));
    }

    @Test
    void testWordEndingWithLe() {
        assertEquals(2, SyllableCounter.countSyllables("bottle"));
    }

    @Test
    void testEdgeCases() {
        assertEquals(1, SyllableCounter.countSyllables("a")); // single letter
        assertThrows(IllegalArgumentException.class, () -> SyllableCounter.countSyllables(""));
        assertThrows(IllegalArgumentException.class, () -> SyllableCounter.countSyllables(null));
    }
}