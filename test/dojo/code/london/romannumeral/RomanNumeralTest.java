package dojo.code.london.romannumeral;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralTest {

    @Test
    public void shouldReturnStringForCollection() throws Exception {
        assertThat(RomanNumeral.romanNumeralsAsString(Arrays.asList(RomanNumeral.I, RomanNumeral.V)), is("IV"));
    }

    @Test
    public void shouldReturnStringForVarArgs() throws Exception {
        assertThat(RomanNumeral.romanNumeralsAsString(RomanNumeral.I, RomanNumeral.V), is("IV"));
    }
}
