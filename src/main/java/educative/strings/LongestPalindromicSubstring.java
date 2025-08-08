package educative.strings;

/*
Problem Statement:
Given a string, find the longest palindromic substring within it.
A palindromic substring is a sequence of characters that reads the same backward as forward.

Examples:
Input:  "babad"
Output: "bab" or "aba"

Input:  "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubstring {
//    public int findLPSLength(String st) {
//        Integer[][] dp = new Integer[st.length()][st.length()];
//        return lpsLength(st, 0 , st.length()-1, dp);
//    }
//
//    public int lpsLength(String input, int start, int end, Integer[][] dp) {
//        if (start > end) {
//            return 0;
//        } else if (start == end) {
//            return 1;
//        }
//        if (dp[start][end] == null) {
//            if (input.charAt(start) == input.charAt(end)) {
//                int remainingLength = end - start - 1;
//                if(remainingLength == lpsLength(input, start + 1, end - 1, dp)) {
//                    dp[start][end] = 2 + remainingLength;
//                    return dp[start][end];
//                }
//            }
//            int c1 = lpsLength(input, start + 1, end, dp);
//            int c2 = lpsLength(input, start, end - 1, dp);
//            dp[start][end] = Math.max(c1, c2);
//
//        }
//        return dp[start][end];
//    }

    public static String findLongestPalindromeSubstringsImproved(String inputString) {
        String longestPalindrome = null;
        if (inputString == null || inputString.length() < 1) return "";

        int start = 0, end = 0;
        for(int i = 0; i < inputString.length(); i++) {
            // left side comparison
            int len1 = findPalindromesInSubStringLength(inputString, i, i);
            // right side comparison
            int len2 = findPalindromesInSubStringLength(inputString, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return inputString.substring(start, end + 1);
    }

    public static int findPalindromesInSubStringLength(String input, int j, int k) {
        // comparing left and right side strings
        for (; j >= 0 && k < input.length(); --j, ++k) {
            // if not palindrome, skip the iteration
            if (input.charAt(j) != input.charAt(k)) {
                break;
            }
        }
        return k - j - 1;
    }
}
