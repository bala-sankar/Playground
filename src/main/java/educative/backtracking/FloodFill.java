package educative.backtracking;

public class FloodFill {
    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        if (grid == null || grid.length == 0) {
            return new int[][]{};
        }
        int color = grid[sr][sc];
        if (color == target) {
            return grid;
        }
        fill(grid, sr, sc, color, target);
        return grid;
    }

    private static void fill(int[][] grid, int r, int c, int color, int target) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != color) {
            return;
        }
        grid[r][c] = target;
        fill(grid, r + 1, c, color, target);
        fill(grid, r - 1, c, color, target);
        fill(grid, r, c + 1, color, target);
        fill(grid, r, c - 1, color, target);
    }
}
