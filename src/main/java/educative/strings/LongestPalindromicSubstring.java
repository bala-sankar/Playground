package educative.strings;

public class LongestPalindromicSubstring {
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
                int remainingLength = end - start - 1;
                if(remainingLength == lpsLength(input, start + 1, end - 1, dp)) {
                    dp[start][end] = 2 + remainingLength;
                    return dp[start][end];
                }
            }
            int c1 = lpsLength(input, start + 1, end, dp);
            int c2 = lpsLength(input, start, end - 1, dp);
            dp[start][end] = Math.max(c1, c2);

        }
        return dp[start][end];
    }
}
