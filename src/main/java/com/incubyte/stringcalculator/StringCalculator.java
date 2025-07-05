package com.incubyte.stringcalculator;

import com.incubyte.stringcalculator.helper.StringCalculatorHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The StringCalculator class provides a method to calculate the sum of numbers in a string.
 * It follows the rules defined in the String Calculator kata assignment by Incubyte.
 */
public class StringCalculator {
    private int callCount = 0;

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
        callCount++;
        return StringCalculatorHelper.calculateSum(numbers);
    }

    /**
     * Returns how many times the add() method has been called.
     *
     * @return the number of times add() was invoked
     */
    public int GetCalledCount() {
        return callCount;
    }

}
