/**
 * @author Edward Yue Shung Wong
 */
public enum RomanNumeral {
    I(1), V(5), X(10);

    private final int value;

    private RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
