package problems;

import java.util.Locale;

/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),

   Hide Hint #1
How can we reuse a previously computed palindrome to compute a larger palindrome?
   Hide Hint #2
If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a palindrome?
   Hide Hint #3
Complexity based hint:
If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.


 */
public class LongestPalindrome {
    private static boolean isPalindrome(String s) {
        return new StringBuilder(s.toLowerCase()).reverse().toString().equals(s.toLowerCase());
    }

    private String longestSubString(String s) {
//        for (int i=0; i < s.length(); i++) {
//            for (int j=i; j < s.length(); j++) {
//                String subString = s.substring(i, j);
//                if
//            }
//        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abcd"));
    }
}
