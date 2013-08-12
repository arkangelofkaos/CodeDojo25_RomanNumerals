package dojo.code.london.romannumeral;

/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralParser {

    public static final String ZERO_STRING = "";

    public static final int DEFAULT_VALUE = 0;
    public static final int ERROR_CODE = -1;

    public static int parseRomanNumeral(String romanNumeralString) {
        if (ZERO_STRING.equals(romanNumeralString)) {
            return DEFAULT_VALUE;
        }

        if (isInvalidRomanNumeral(romanNumeralString)) {
            return ERROR_CODE;
        }

        int value = 0;

        try {
            RomanNumeral lastValue = null;

            for (char numeral : romanNumeralString.toCharArray()) {
                RomanNumeral romanNumeral = RomanNumeral.valueOf(String.valueOf(numeral));

                if (lastValue != null && lastValue.ordinal() < romanNumeral.ordinal()) {
                    value -= 2 * lastValue.getValue();
                }
                value += romanNumeral.getValue();
                lastValue = romanNumeral;
            }
        } catch (Exception ex) {
            return ERROR_CODE;
        }

        return value;
    }

    private static boolean isInvalidRomanNumeral(String romanNumeralString) {
        if (romanNumeralString == null) {
            return false;
        }

        for (int i = 2; i < romanNumeralString.length(); i++) {
            int first = RomanNumeral.valueOf(String.valueOf(romanNumeralString.charAt(i - 2))).ordinal();
            int second = RomanNumeral.valueOf(String.valueOf(romanNumeralString.charAt(i - 1))).ordinal();
            int third = RomanNumeral.valueOf(String.valueOf(romanNumeralString.charAt(i))).ordinal();

            if (first <= second && second < third) {
                return true;
            }
        }

        return false;
    }
}
