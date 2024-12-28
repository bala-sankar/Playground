package educative.matrices;

public class FindExit {
    public static int[] findExitColumn(int[][] grid) {

        // Replace this placeholder return statement with your code
        int rows = grid.length;
        int cols = grid[0].length;
        int[] result = new int[cols];
        for (int ball = 0; ball < cols; ball++) {
            int c = ball;
            for (int r = 0; r < rows; r++) {
                if ((grid[r][c] == -1 && c == 0)
                        || (grid[r][c] == 1 && c == cols - 1)
                        || (grid[r][c] == 1 && grid[r][c + 1] == -1)
                        || (grid[r][c] == -1 && grid[r][c - 1] == 1)) {
                    c = -1;
                    break;
                } else if (grid[r][c] == 1) {
                    c++;
                } else if (grid[r][c] == -1) {
                    c--;
                }

            }
            result[ball] = c;
        }
        return result;
    }
}
