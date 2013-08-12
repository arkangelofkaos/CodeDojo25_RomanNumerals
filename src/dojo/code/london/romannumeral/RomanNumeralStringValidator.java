package dojo.code.london.romannumeral;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralStringValidator {

    public static boolean isInvalidRomanNumeral(String romanNumeralString) {
        if (romanNumeralString == null) {
            return false;
        }

        try {
            Collection<String> rawRomanNumerals = new ArrayList<>(romanNumeralString.length());
            for (char rawRomanNumeral : romanNumeralString.toCharArray()) {
                rawRomanNumerals.add(String.valueOf(rawRomanNumeral));
            }

            RomanNumeral[] romanNumerals = rawRomanNumerals.parallelStream()
                    .map(RomanNumeral::valueOf)
                    .toArray(RomanNumeral[]::new);

            for (int i = 2; i < romanNumerals.length; i++) {
                int first = romanNumerals[i - 2].ordinal();
                int second = romanNumerals[i - 1].ordinal();
                int third = romanNumerals[i].ordinal();

                if (first <= second && second < third) {
                    return true;
                }
            }
        } catch (IllegalArgumentException ex) {
            return true;
        }

        return false;
    }

}
