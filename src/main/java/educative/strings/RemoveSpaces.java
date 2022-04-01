package educative.strings;

import java.util.Arrays;

public class RemoveSpaces {
    static String removeWhiteSpaces(char[] s) {
        int readPtr = 0, writePtr = 0;
        for(char c : s) {
            if(!Character.isWhitespace(c)) {
                s[writePtr] = s[readPtr];
                writePtr++;
            }
            readPtr++;
        }
        return String.valueOf(Arrays.copyOfRange(s, 0, writePtr));
    }
}
