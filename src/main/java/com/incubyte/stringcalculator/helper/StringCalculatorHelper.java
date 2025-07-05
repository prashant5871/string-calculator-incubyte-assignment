package com.incubyte.stringcalculator.helper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A helper class that provides the core logic for the String Calculator.
 * Handles parsing custom delimiters, validating input, and computing the sum
 * of comma/newline or custom-delimited integers from a string.
 *
 * <p>Supports advanced features like:</p>
 * <ul>
 *   <li>Custom single or multi-character delimiters</li>
 *   <li>Multiple delimiters</li>
 *   <li>Ignoring numbers > 1000</li>
 *   <li>Throwing exception for negative numbers</li>
 * </ul>
 */
public class StringCalculatorHelper {

    /**
     * Calculates the sum of numbers in the given input string.
     * Supports default delimiters (comma and newline), and custom delimiters
     * using the "//[delimiter]\n" or "//[d1][d2]\n" format.
     *
     * @param input the input string to be evaluated
     * @return the sum of valid numbers
     * @throws IllegalArgumentException if any negative numbers are found
     */
    public static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = extractCustomDelimiter(input.substring(2, delimiterEndIndex));
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = input.split(delimiter);
        return compute(tokens);
    }

    /**
     * Extracts a delimiter (or multiple delimiters) from a custom delimiter definition.
     * Handles single delimiters like ";" and multiple delimiters like [***], [%%], etc.
     *
     * @param def the raw delimiter definition string (excluding the "//" and "\n")
     * @return a regex-safe delimiter string usable with String.split()
     */
    private static String extractCustomDelimiter(String def) {
        if (def.startsWith("[") && def.endsWith("]")) {
            List<String> delimiters = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(def);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }
            return String.join("|", delimiters); // e.g., \Q*\E|\Q%\E
        } else {
            return Pattern.quote(def);
        }
    }

    /**
     * Computes the sum of numbers from an array of string tokens.
     * - Ignores numbers greater than 1000
     * - Accumulates negative numbers and throws an exception if found
     *
     * @param tokens the array of number strings
     * @return the sum of valid (non-negative and ≤1000) numbers
     * @throws IllegalArgumentException if any negative numbers are present
     */
    private static int compute(String[] tokens) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    negatives.add(num);
                } else if (num <= 1000) {
                    sum += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " +
                    negatives.stream().map(String::valueOf).collect(Collectors.joining(", "))
            );
        }

        return sum;
    }
}
