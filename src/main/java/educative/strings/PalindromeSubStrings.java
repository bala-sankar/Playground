package educative.strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubStrings {
    // This function receives input and returns palindromes list
    public static List<String> findAllPalindromeSubstrings(String inputString) {
        List<String> palindromes = new ArrayList<String>();
        for(int i = 0; i < inputString.length(); i++) {
            for(int j = i+1; j < inputString.length(); j++) {
                if(isPalindrome(inputString, i, j)) {
                    palindromes.add(inputString.substring(i, j));
                }
            }
        }
        return palindromes;
    }

    public static List<String> findAllPalindromeSubstringsImproved(String inputString) {
        List<String> palindromes = new ArrayList<String>();
        for(int i = 0; i < inputString.length(); i++) {
            // left side comparison
            findPalindromesInSubString(inputString, i - 1, i + 1, palindromes);
            // right side comparison
            findPalindromesInSubString(inputString, i, i + 1, palindromes);
        }
        return palindromes;
    }

    public static void findPalindromesInSubString(String input, int j, int k,
                                                  List<String> palindrome) {
        // comparing left and right side strings
        for (; j >= 0 && k < input.length(); --j, ++k) {
            // if not palindrome, skip the next iteration
            if (input.charAt(j) != input.charAt(k)) {
                break;
            }

            // storing the palindromes in result
            palindrome.add(input.substring(j, k + 1));
        }
    }

    public static boolean isPalindrome(String input, int start, int last) {
        while (last > start) {
            if (input.charAt(start) != input.charAt(last))
                return false;
            start++;
            last--;
        }
        return true;
    }
}
