/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralParser {

    public static final String EMPTY_STRING = "";
    private static final String A_SINGLE_SPACE = " ";
    private static final String INVALID_INPUT = ".";

    public static final int DEFAULT_VALUE = 0;
    public static final int ERROR_CODE = -1;


    public static int parseRomanNumeral(String romanNumeralString) {
        if (EMPTY_STRING.equals(romanNumeralString)) {
            return DEFAULT_VALUE;
        }

        if (isInvalidRomanNumeral(romanNumeralString)) {
            return ERROR_CODE;
        }

        int value = 0;
        RomanNumeral lastValue = null;

        for (char numeral : romanNumeralString.toCharArray()) {
            RomanNumeral romanNumeral = RomanNumeral.valueOf(String.valueOf(numeral));
            if (lastValue != null && lastValue.ordinal() < romanNumeral.ordinal()) {
                value -= 2 * lastValue.getValue();
            }
            value += romanNumeral.getValue();
            lastValue = romanNumeral;
        }

        return value;
    }

    private static boolean isInvalidRomanNumeral(String romanNumeralString) {
        if (romanNumeralString == null || A_SINGLE_SPACE.equals(romanNumeralString)
                || INVALID_INPUT.equals(romanNumeralString)) {
            return true;
        }

        if (romanNumeralString.length() < 3) {
            return false;
        }

        for (int i = 2; i < romanNumeralString.length(); i++) {
            int first = RomanNumeral.valueOf(String.valueOf(romanNumeralString.charAt(i - 2))).ordinal();
            int second = RomanNumeral.valueOf(String.valueOf(romanNumeralString.charAt(i - 1))).ordinal();
            int thrid = RomanNumeral.valueOf(String.valueOf(romanNumeralString.charAt(i))).ordinal();

            if (first <= second && second < thrid) {
                return true;
            }
        }

        return false;
    }
}
