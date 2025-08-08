package educative.strings;

import java.util.Arrays;

/*
Problem Statement:
Given a character array, remove all whitespace characters and return the resulting string.

Examples:
Input:  ['a',' ','b',' ','c']
Output: "abc"

Input:  [' ','h','e','l','l','o',' ','w','o','r','l','d',' ']
Output: "helloworld"
*/

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
