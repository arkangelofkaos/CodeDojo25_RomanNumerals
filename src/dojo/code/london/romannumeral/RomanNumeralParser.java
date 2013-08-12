package dojo.code.london.romannumeral;

import static dojo.code.london.romannumeral.RomanNumeralStringValidator.isInvalidRomanNumeral;

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

}
