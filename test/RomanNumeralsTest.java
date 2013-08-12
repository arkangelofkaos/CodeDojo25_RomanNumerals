import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralsTest {

    private static final String A_SINGLE_SPACE = " ";
    public static final String ROMAN_NUMERAL_ONE = "I";
    public static final int ERROR_CODE = -1;
    public static final int DEFAULT_VALUE = 0;
    private static final String INVALID_INPUT = ".";

    @Test
    public void shouldReturnMinusOneWhenANullValueIsPassedToTheFunction() {
        int expectedValue = ERROR_CODE;
        String romanNumeralString = null;
        int actualValue = parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return -1", actualValue, expectedValue);
    }

    @Test
    public void shouldReturn0WhenEmptyStringIsParsedIn() throws Exception {
        int expectedValue = DEFAULT_VALUE;
        String romanNumeralString = "";
        int actualValue = parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return 0 for empty string", actualValue, expectedValue);
    }

    @Test
    public void should_Return_MinusOneForASpaceAsInput() {
        int actualValue = parseRomanNumeral(A_SINGLE_SPACE);
        int expectedValue = ERROR_CODE;
        assertEquals("Did not return -1 for a string with a space", actualValue, expectedValue);
    }

    @Test
    public void shouldReturn1ForRomanNumeralI() throws Exception {
        int expectedValue = 1;
        String romanNumeralString = ROMAN_NUMERAL_ONE;
        int actualValue = parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return 1", actualValue, expectedValue);
    }

    @Test
    public void shouldReturnAnErrorCodeForInvalidInput() {
        int actualValue = parseRomanNumeral(INVALID_INPUT);
        assertEquals("Should have returned an error code of -1", actualValue, ERROR_CODE);
    }

    private int parseRomanNumeral(String romanNumeralString) {
        if (romanNumeralString == null || A_SINGLE_SPACE.equals(romanNumeralString)) {
            return ERROR_CODE;
        }

        if (ROMAN_NUMERAL_ONE.equals(romanNumeralString)) {
            return 1;
        }

        return DEFAULT_VALUE;
    }
}
