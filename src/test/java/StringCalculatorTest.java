import com.incubyte.stringcalculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the StringCalculator class.
 * This follows the TDD approach: Red -> Green -> Refactor.
 */
public class StringCalculatorTest {

    /**
     * Test case: input is an empty string.
     * Expected behavior: should return 0.
     */
    @Test
    public void testAddWithEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
}