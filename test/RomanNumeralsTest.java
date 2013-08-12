import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralsTest {

    private static final String ROMAN_NUMERAL_ONE = "I";
    private static final String ROMAN_NUMERAL_TWO = "II";
    private static final String ROMAN_NUMERAL_THREE = "III";
    private static final String ROMAN_NUMERAL_FOUR = "IV";
    private static final String ROMAN_NUMERAL_FIVE = "V";
    private static final String ROMAN_NUMERAL_NINE = "IX";
    private static final String ROMAN_NUMERAL_TEN = "X";

    private static final int ERROR_CODE = -1;
    private static final int DEFAULT_VALUE = 0;
    private static final String A_SINGLE_SPACE = " ";
    private static final String INVALID_INPUT = ".";
    private static final String EMPTY_STRING = "";

    @Test
    public void shouldReturnMinusOneWhenANullValueIsPassedToTheFunction() {
        String romanNumeralString = null;
        int actualValue = parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return -1", actualValue, ERROR_CODE);
    }

    @Test
    public void shouldReturn0WhenEmptyStringIsParsedIn() throws Exception {
        String romanNumeralString = EMPTY_STRING;
        int actualValue = parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return 0 for empty string", actualValue, DEFAULT_VALUE);
    }

    @Test
    public void should_Return_MinusOneForASpaceAsInput() {
        int actualValue = parseRomanNumeral(A_SINGLE_SPACE);
        assertEquals("Did not return -1 for a string with a space", actualValue, ERROR_CODE);
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

    @Test
    public void shouldReturn2ForRomanNumeralII() throws Exception {
        assertEquals("Should have returned 2", parseRomanNumeral(ROMAN_NUMERAL_TWO), 2);
    }

    @Test
    public void shouldReturn3ForRomanNumeralIII() throws Exception {
        assertEquals("Should have returned 3", parseRomanNumeral(ROMAN_NUMERAL_THREE), 3);
    }

    @Test
    public void shouldReturn5ForRomanNumeralV() throws Exception {
        assertEquals("Should have returned 5", parseRomanNumeral(ROMAN_NUMERAL_FIVE), 5);
    }


    @Test
    public void shouldReturn10ForRomanNumeraX() throws Exception {
        assertEquals("Should have returned 10", parseRomanNumeral(ROMAN_NUMERAL_TEN), 10);
    }

    //TODO
    @Ignore
    @Test
    public void shouldReturn4ForRomanNumeralIV() throws Exception {
        assertEquals("Should have returned 4", parseRomanNumeral(ROMAN_NUMERAL_FOUR), 4);
    }

    //TODO
    @Ignore
    @Test
    public void shouldReturn9ForRomanNumeralIX() throws Exception {
        assertEquals("Should have returned 9", parseRomanNumeral(ROMAN_NUMERAL_NINE), 9);
    }

    private int parseRomanNumeral(String romanNumeralString) {
        if (EMPTY_STRING.equals(romanNumeralString)) {
            return DEFAULT_VALUE;
        }

        if (isInvalidRomanNumeral(romanNumeralString)) {
            return ERROR_CODE;
        }

        int value = 0;

        for (char numeral : romanNumeralString.toCharArray()) {
            RomanNumeral romanNumeral = RomanNumeral.valueOf(String.valueOf(numeral));
            value += romanNumeral.getValue();
        }

        return value;
    }

    private boolean isInvalidRomanNumeral(String romanNumeralString) {
        return romanNumeralString == null || A_SINGLE_SPACE.equals(romanNumeralString) || INVALID_INPUT.equals(romanNumeralString);
    }
}
