package educative.dynamic;

public class Knapsack {
    public static int findMaxKnapsackProfit(int capacity, int [] weights, int [] values) {
        int n = weights.length;
        int [][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = values[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                if (weights[i] <= c) {
                    profit1 = values[i] + dp[i - 1][c - weights[i]];
                }
                int profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n - 1][capacity];
    }

    public static void main(String[] args) {
        int [] weights = {2, 3, 1, 4};
        int [] values = {4, 5, 3, 7};
        int capacity = 5;
        System.out.println(findMaxKnapsackProfit(capacity, weights, values));
    }
}
