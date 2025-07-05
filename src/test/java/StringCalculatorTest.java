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

}