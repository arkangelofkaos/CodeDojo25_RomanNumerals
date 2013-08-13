package dojo.code.london.romannumeral;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @author Edward Yue Shung Wong
 */
public enum RomanNumeral {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private final int value;

    private RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String romanNumeralsAsString(RomanNumeral... numerals) {
        return romanNumeralStreamToString(Arrays.parallelStream(numerals));
    }

    public static String romanNumeralsAsString(Collection<RomanNumeral> numerals) {
        return romanNumeralStreamToString(numerals.parallelStream());
    }

    private static String romanNumeralStreamToString(Stream<RomanNumeral> romanNumeralStream) {
        return romanNumeralStream
                .map(RomanNumeral::name)
                .reduce(String::concat)
                .get();
    }
}
