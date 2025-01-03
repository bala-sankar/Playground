package educative.backtracking;

public class NQueens {
    public static int solveNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 0;
        int[] queens = new int[n];
        return solveNQueens(queens, 0, result);
    }

    private static int solveNQueens(int[] queens, int row, int result) {
        // Base case
        if (row == queens.length) {
            result++;
            return result;
        }
        // Recursive case
        for (int col = 0; col < queens.length; col++) {
            // Check if the current position is valid
            if (isValid(queens, row, col)) {
                queens[row] = col;
                result = solveNQueens(queens, row + 1, result);
            }
        }
        return result;
    }

    private static boolean isValid(int[] queens, int row, int col) {
        // Check if the current position is in the same column or diagonals with the previous queens
        for (int i = 0; i < row; i++) {
            // Check if the current position is in the same column or diagonals with the previous queens
            if (queens[i] == col || queens[i] - col == i - row || queens[i] - col == row - i) {
                return false;
            }
        }
        return true;
    }
}
