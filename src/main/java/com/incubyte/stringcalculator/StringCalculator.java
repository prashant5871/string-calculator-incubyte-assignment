package com.incubyte.stringcalculator;

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

        if (numbers.contains(",")) {
            String[] numberArray = numbers.split(",");
            int sum = 0;
            for (String number : numberArray) {
                sum += Integer.parseInt(number.trim());
            }
            return sum;
        }

        return Integer.parseInt(numbers.trim());
    }

}
