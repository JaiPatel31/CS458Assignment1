package org.example;
import java.util.List;

public class AdjustedAverageCalculator {
    public static double adjustedAverage(List<Integer> numbers) {
        if (numbers == null || numbers.size() <= 2) {
            throw new IllegalArgumentException("List must contain more than 2 elements");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Remove one occurrence of min and max from sum
        sum -= min;
        sum -= max;

        // Calculate adjusted average
        return (double) sum / (numbers.size() - 2);
    }
}

