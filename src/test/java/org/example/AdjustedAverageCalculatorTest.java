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
}