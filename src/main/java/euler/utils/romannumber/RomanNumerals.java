package euler.utils.romannumber;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 11/14/12
 */
public enum RomanNumerals {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    int value;

    RomanNumerals(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }

    /*RomanNumerals next() {
        switch (this) {
            case I:
                return RomanNumerals.V;
            case V:
                return RomanNumerals.X;
            case X:
                return RomanNumerals.L;
            case L:
                return RomanNumerals.C;
            case C:
                return RomanNumerals.D;
            case D:
                return RomanNumerals.M;
        }
        throw new IllegalArgumentException("This Roman character's next operation is not supported");
    }*/

    static int getValue(char a) {
        switch (a) {
            case 'I':
                return RomanNumerals.I.getValue();
            case 'V':
                return RomanNumerals.V.getValue();
            case 'X':
                return RomanNumerals.X.getValue();
            case 'L':
                return RomanNumerals.L.getValue();
            case 'C':
                return RomanNumerals.C.getValue();
            case 'D':
                return RomanNumerals.D.getValue();
            case 'M':
                return RomanNumerals.M.getValue();
        }
        throw new IllegalArgumentException("Roman character is not supported");
    }

    public static int getRomanValue(String romanNumber) {
        if (romanNumber.length() < 1) {
            throw new IllegalArgumentException("Invalid roman number");
        }
        romanNumber = romanNumber.replaceAll("IV", "IIII");
        romanNumber = romanNumber.replaceAll("IX", "VIIII");
        romanNumber = romanNumber.replaceAll("XL", "XXXX");
        romanNumber = romanNumber.replaceAll("XC", "LXXXX");
        romanNumber = romanNumber.replaceAll("CD", "CCCC");
        romanNumber = romanNumber.replaceAll("CM", "DCCCC");

        int sum = 0;
        for (int index = romanNumber.length() - 1; index >= 0; index--) {
            sum = sum + getValue(romanNumber.charAt(index));
        }
        return sum;
    }

    public static String getMinimalRomanNumber(String value) {
        return getMinimalRomanNumber(getRomanValue(value));
    }

    public static String getMinimalRomanNumber(int value) {
        StringBuilder romanNumber = new StringBuilder();
        while (value != 0) {
            if (0 < (value / RomanNumerals.M.getValue())) {
                value = CreateRomanNumeral(value, romanNumber, RomanNumerals.M);
            } else if (0 < (value / RomanNumerals.D.getValue())) {
                value = CreateRomanNumeral(value, romanNumber, RomanNumerals.D);
            } else if (0 < (value / RomanNumerals.C.getValue())) {
                value = CreateRomanNumeral(value, romanNumber, RomanNumerals.C);
            } else if (0 < (value / RomanNumerals.L.getValue())) {
                value = CreateRomanNumeral(value, romanNumber, RomanNumerals.L);
            } else if (0 < (value / RomanNumerals.X.getValue())) {
                value = CreateRomanNumeral(value, romanNumber, RomanNumerals.X);
            } else if (0 < (value / RomanNumerals.V.getValue())) {
                value = CreateRomanNumeral(value, romanNumber, RomanNumerals.V);
            } else if (0 < (value / RomanNumerals.I.getValue())) {
                value = CreateRomanNumeral(value, romanNumber, RomanNumerals.I);
            }
        }

        String number = romanNumber.toString();
        number = number.replaceAll("VIIII", "IX");
        number = number.replaceAll("IIII", "IV");
        number = number.replaceAll("LXXXX", "XC");
        number = number.replaceAll("XXXX", "XL");
        number = number.replaceAll("DCCCC", "CM");
        number = number.replaceAll("CCCC", "CD");

        return number;
    }

    private static int CreateRomanNumeral(int value, StringBuilder romanNumber, RomanNumerals number) {
        int temp = value / number.getValue();
        for (int i = 1; i <= (temp); i++) {
            romanNumber.append(number.toString());
        }
        value = value % number.getValue();
        return value;
    }

}
