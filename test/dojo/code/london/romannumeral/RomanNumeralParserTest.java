package dojo.code.london.romannumeral;

import org.junit.Test;

import static dojo.code.london.romannumeral.RomanNumeral.*;
import static junit.framework.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralParserTest {

    private static final String ROMAN_NUMERAL_ONE = romanNumeralsAsString(I);
    private static final String ROMAN_NUMERAL_TWO = romanNumeralsAsString(I, I);
    private static final String ROMAN_NUMERAL_THREE = romanNumeralsAsString(I, I, I);
    private static final String ROMAN_NUMERAL_FOUR = romanNumeralsAsString(I, V);
    private static final String ROMAN_NUMERAL_FIVE = romanNumeralsAsString(V);
    private static final String ROMAN_NUMERAL_NINE = romanNumeralsAsString(I, X);
    private static final String ROMAN_NUMERAL_TEN = romanNumeralsAsString(X);

    private static final String A_SINGLE_SPACE = " ";
    private static final String INVALID_INPUT = ".";

    @Test
    public void shouldReturnMinusOneWhenANullValueIsPassedToTheFunction() {
        String romanNumeralString = null;
        int actualValue = RomanNumeralParser.parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return -1", actualValue, RomanNumeralParser.ERROR_CODE);
    }

    @Test
    public void shouldReturn0WhenEmptyStringIsParsedIn() throws Exception {
        String romanNumeralString = RomanNumeralParser.ZERO_STRING;
        int actualValue = RomanNumeralParser.parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return 0 for empty string", actualValue, RomanNumeralParser.DEFAULT_VALUE);
    }

    @Test
    public void should_Return_MinusOneForASpaceAsInput() {
        int actualValue = RomanNumeralParser.parseRomanNumeral(A_SINGLE_SPACE);
        assertEquals("Did not return -1 for a string with a space", actualValue, RomanNumeralParser.ERROR_CODE);
    }

    @Test
    public void shouldReturn1ForRomanNumeralI() throws Exception {
        int expectedValue = 1;
        String romanNumeralString = ROMAN_NUMERAL_ONE;
        int actualValue = RomanNumeralParser.parseRomanNumeral(romanNumeralString);
        assertEquals("Did not return 1", actualValue, expectedValue);
    }

    @Test
    public void shouldReturnAnErrorCodeForInvalidInput() {
        int actualValue = RomanNumeralParser.parseRomanNumeral(INVALID_INPUT);
        assertEquals("Should have returned an error code of -1", actualValue, RomanNumeralParser.ERROR_CODE);
    }

    @Test
    public void shouldReturn2ForRomanNumeralII() throws Exception {
        assertEquals("Should have returned 2", RomanNumeralParser.parseRomanNumeral(ROMAN_NUMERAL_TWO), 2);
    }

    @Test
    public void shouldReturn3ForRomanNumeralIII() throws Exception {
        assertEquals("Should have returned 3", RomanNumeralParser.parseRomanNumeral(ROMAN_NUMERAL_THREE), 3);
    }

    @Test
    public void shouldReturn5ForRomanNumeralV() throws Exception {
        assertEquals("Should have returned 5", RomanNumeralParser.parseRomanNumeral(ROMAN_NUMERAL_FIVE), 5);
    }

    @Test
    public void shouldReturn10ForRomanNumeraX() throws Exception {
        assertEquals("Should have returned 10", RomanNumeralParser.parseRomanNumeral(ROMAN_NUMERAL_TEN), 10);
    }

    @Test
    public void shouldReturn4ForRomanNumeralIV() throws Exception {
        assertEquals("Should have returned 4", RomanNumeralParser.parseRomanNumeral(ROMAN_NUMERAL_FOUR), 4);
    }

    @Test
    public void shouldReturn9ForRomanNumeralIX() throws Exception {
        assertEquals("Should have returned 9", RomanNumeralParser.parseRomanNumeral(ROMAN_NUMERAL_NINE), 9);
    }

    @Test
    public void shouldReturn1993ForMCMXCIII() throws Exception {
        assertEquals(RomanNumeralParser.parseRomanNumeral("MCMXCIII"), 1993);
    }

    @Test()
    public void shouldReturnErrorWhenTwoOrMoreSmallerNumbersBeforeLargeOne() throws Exception {
        assertEquals(RomanNumeralParser.parseRomanNumeral("IIV"), RomanNumeralParser.ERROR_CODE);
    }
}
