package educative.strings;

/*
Problem Statement:
Given a string, find the length of the longest palindromic subsequence.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Examples:
Input:  "bbbab"
Output: 4
Explanation: The longest palindromic subsequence is "bbbb".

Input:  "cbbd"
Output: 2
Explanation: The longest palindromic subsequence is "bb".
*/

public class LongestPalindromicSubsequence {
    public int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return lpsLength(st, 0 , st.length()-1, dp);
    }

    public int lpsLength(String input, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        } else if (start == end) {
            return 1;
        }
        if (dp[start][end] == null) {
            if (input.charAt(start) == input.charAt(end)) {
                dp[start][end] = 2 + lpsLength(input, start + 1, end - 1, dp);
            } else {
                int c1 = lpsLength(input, start + 1, end, dp);
                int c2 = lpsLength(input, start, end - 1, dp);
                dp[start][end] = Math.max(c1, c2);
            }
        }
        return dp[start][end];
    }

    // Minimum deletion to make a palindrome.
    public int findMinimumDeletions(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        return st.length() - findLPSLength(st);
    }
}
