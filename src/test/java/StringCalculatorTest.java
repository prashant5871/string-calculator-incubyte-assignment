import com.incubyte.stringcalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the StringCalculator class.
 * This follows the TDD approach: Red -> Green -> Refactor.
 */
public class StringCalculatorTest {

    private StringCalculator calculator;

    /**
     * This method runs before each test.
     * It initializes a new instance of StringCalculator to ensure clean test state.
     */
    @BeforeEach
    void setup() {
        calculator = new StringCalculator();
    }

    /**
     * Test case: input is an empty string.
     * Expected behavior: should return 0.
     */
    @Test
    public void testAddWithEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    /**
     * Test case: input is a single number.
     * Expected behavior: should return the number itself.
     */
    @Test
    public void testAddWithSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }

    /**
     * Test case: input contains two numbers separated by a comma.
     * Expected behavior: should return their sum.
     */
    @Test
    public void testAddWithTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

    /**
     * Test case: input contains multiple comma-separated numbers.
     * Expected behavior: should return the sum of all numbers.
     */
    @Test
    public void testAddWithMultipleNumbers() {
        assertEquals(10, calculator.add("1,2,3,4"));
    }

    /**
     * Test case: input contains numbers separated by commas and new lines.
     * Expected behavior: should return the correct sum.
     */
    @Test
    public void testAddWithNewlineDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    /**
     * Test case: input starts with custom delimiter definition using "//[delimiter]\n".
     * Expected behavior: should use the custom delimiter to separate numbers.
     */
    @Test
    public void testAddWithCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    /**
     * Test case: input contains negative numbers.
     * Expected behavior: should throw an exception listing all negatives.
     */
    @Test
    public void testAddWithNegativeNumbers() {
        IllegalArgumentException thrown =
                org.junit.jupiter.api.Assertions.assertThrows(
                        IllegalArgumentException.class,
                        () -> calculator.add("1,-2,3,-5")
                );

        assertEquals("negatives not allowed: -2, -5", thrown.getMessage());
    }

    /**
     * Test case: input contains numbers greater than 1000.
     * Expected behavior: such numbers should be ignored in the sum.
     */
    @Test
    public void testAddIgnoresNumbersGreaterThan1000() {
        assertEquals(2, calculator.add("2,1001"));
        assertEquals(1001, calculator.add("1000,1"));
        assertEquals(3, calculator.add("1234\n1,2"));
    }


}