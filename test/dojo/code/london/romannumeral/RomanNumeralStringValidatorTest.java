package dojo.code.london.romannumeral;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Edward Yue Shung Wong
 */
public class RomanNumeralStringValidatorTest {

    @Test
    public void shouldBeInvalidForAllWildlyInvalidInput() throws Exception {
        assertThat(RomanNumeralStringValidator.isInvalidRomanNumeral("foo"), is(true));
        assertThat(RomanNumeralStringValidator.isInvalidRomanNumeral(" "), is(true));
    }
}
