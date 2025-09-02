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

    @Test
    void testSky() {
        assertEquals(1, SyllableCounter.countSyllables("Sky"));
    }

    @Test
    void testRhythm() {
        assertEquals(1, SyllableCounter.countSyllables("Rhythm"));
    }

    @Test
    void testBook() {
        assertEquals(1, SyllableCounter.countSyllables("Book"));
    }

    @Test
    void testApple() {
        assertEquals(2, SyllableCounter.countSyllables("Apple"));
    }

    @Test
    void testHappy() {
        assertEquals(2, SyllableCounter.countSyllables("Happy"));
    }

    @Test
    void testOpen() {
        assertEquals(2, SyllableCounter.countSyllables("Open"));
    }

    @Test
    void testAnimal() {
        assertEquals(3, SyllableCounter.countSyllables("Animal"));
    }

    @Test
    void testChocolate() {
        assertEquals(3, SyllableCounter.countSyllables("Chocolate"));
    }

    @Test
    void testComputer() {
        assertEquals(3, SyllableCounter.countSyllables("Computer"));
    }

    @Test
    void testCelebration() {
        assertEquals(4, SyllableCounter.countSyllables("Celebration"));
    }

    @Test
    void testVoluntary() {
        assertEquals(4, SyllableCounter.countSyllables("Voluntary"));
    }

    @Test
    void testCalifornia() {
        assertEquals(4, SyllableCounter.countSyllables("California"));
    }

    @Test
    void testIncomparable() {
        assertEquals(5, SyllableCounter.countSyllables("Incomparable"));
    }

    @Test
    void testOpportunity() {
        assertEquals(5, SyllableCounter.countSyllables("Opportunity"));
    }

    @Test
    void testMisunderstanding() {
        assertEquals(5, SyllableCounter.countSyllables("Misunderstanding"));
    }

    @Test
    void testUnintentionally() {
        assertTrue(SyllableCounter.countSyllables("Unintentionally") >= 6);
    }

    @Test
    void testMisinterpretation() {
        assertTrue(SyllableCounter.countSyllables("Misinterpretation") >= 6);
    }

    @Test
    void testIncomprehensible() {
        assertTrue(SyllableCounter.countSyllables("Incomprehensible") >= 6);
    }

    @Test
    void testDisproportionately() {
        assertTrue(SyllableCounter.countSyllables("Disproportionately") >= 6);
    }

    @Test
    void testUnconstitutionalities() {
        assertTrue(SyllableCounter.countSyllables("Unconstitutionalities") >= 7);
    }

    @Test
    void testIncomprehensibility() {
        assertTrue(SyllableCounter.countSyllables("Incomprehensibility") >= 7);
    }

    @Test
    void testInternationalization() {
        assertTrue(SyllableCounter.countSyllables("Internationalization") >= 7);
    }

    @Test
    void testAntidisestablishmentarianism() {
        assertTrue(SyllableCounter.countSyllables("Antidisestablishmentarianism") >= 10);
    }
}