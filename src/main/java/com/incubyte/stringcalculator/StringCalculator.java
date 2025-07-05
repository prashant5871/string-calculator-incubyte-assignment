package com.incubyte.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The StringCalculator class provides a method to calculate the sum of numbers in a string.
 * It follows the rules defined in the String Calculator kata assignment by Incubyte.
 */
public class StringCalculator {

    /**
     * Adds numbers provided in the input string.
     * <p>
     * Rules:
     * <ul>
     *     <li>If the input is empty, returns 0.</li>
     *     <li>Numbers are separated by commas or new lines.</li>
     *     <li>Supports an unknown amount of numbers.</li>
     *     <li>Delimiters can be changed using "//[delimiter]\n" format.</li>
     *     <li>Negative numbers throw an exception.</li>
     *     <li>Numbers > 1000 are ignored.</li>
     * </ul>
     * </p>
     *
     * @param numbers the input string containing numbers to add
     * @return the sum of the numbers
     */
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            delimiter = Pattern.quote(numbers.substring(2, delimiterEndIndex));
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    negatives.add(num);
                } else {
                    sum += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negatives not allowed: " + negatives.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "))
            );
        }

        return sum;
    }


}
