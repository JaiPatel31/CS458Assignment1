package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AdjustedAverageCalculatorTest {

    @Test
    void testBasicCase() {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        assertEquals(30.0, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testWithNegativeNumbers() {
        List<Integer> numbers = List.of(-10, 0, 10, 20, 30);
        assertEquals(10.0, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testAllSameValues() {
        List<Integer> numbers = List.of(5, 5, 5, 5, 5);
        assertEquals(5.0, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testListWithThreeElements() {
        List<Integer> numbers = List.of(1, 2, 3);
        assertEquals(2.0, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testLargeNumbers() {
        List<Integer> numbers = List.of(1_000_000, 2_000_000, 3_000_000, 4_000_000, 5_000_000);
        assertEquals(3_000_000.0, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testUnsortedList() {
        List<Integer> numbers = List.of(50, 10, 30, 40, 20);
        assertEquals(30.0, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testDuplicateMinMaxValues() {
        List<Integer> numbers = List.of(10, 10, 20, 30, 50, 50);
        assertEquals(20.0 + 30.0 + 10.0 + 50.0,
                AdjustedAverageCalculator.adjustedAverage(numbers) * 4, 0.001);
    }

    @Test
    void testMinimumListSizeThrowsException() {
        List<Integer> numbers = List.of(10, 20);
        assertThrows(IllegalArgumentException.class, () -> AdjustedAverageCalculator.adjustedAverage(numbers));
    }

    @Test
    void testNullListThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> AdjustedAverageCalculator.adjustedAverage(null));
    }

    @Test
    void testWithZeros() {
        List<Integer> numbers = List.of(0, 0, 0, 0, 0);
        assertEquals(0.0, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testAllMaxIntegers() {
        List<Integer> numbers = List.of(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        double expected = ((long) Integer.MAX_VALUE * 5 - Integer.MAX_VALUE - Integer.MAX_VALUE) / 3.0;
        assertEquals(expected, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testAllMinIntegers() {
        List<Integer> numbers = List.of(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        double expected = ((long) Integer.MIN_VALUE * 5 - Integer.MIN_VALUE - Integer.MIN_VALUE) / 3.0;
        assertEquals(expected, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testMixedMaxAndMinIntegers() {
        List<Integer> numbers = List.of(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        // Remove one MAX and one MIN, remaining: Integer.MAX_VALUE + Integer.MIN_VALUE + 0
        long remainingSum = (long) Integer.MAX_VALUE + Integer.MIN_VALUE;
        double expected = remainingSum / 3.0;
        assertEquals(expected, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testLargePositiveNumbers() {
        List<Integer> numbers = List.of(1_000_000_000, 1_000_000_001, 1_000_000_002, 1_000_000_003, 1_000_000_004);
        // Remove min and max: remove 1_000_000_000 and 1_000_000_004
        long remainingSum = 1_000_000_001L + 1_000_000_002L + 1_000_000_003L;
        double expected = remainingSum / 3.0;
        assertEquals(expected, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }

    @Test
    void testNearOverflowSum() {
        List<Integer> numbers = List.of(Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 4);
        // Remove min and max: remove MAX_VALUE and MAX_VALUE - 4
        long remainingSum = (long) (Integer.MAX_VALUE - 1) + (Integer.MAX_VALUE - 2) + (Integer.MAX_VALUE - 3);
        double expected = remainingSum / 3.0;
        assertEquals(expected, AdjustedAverageCalculator.adjustedAverage(numbers), 0.001);
    }


}