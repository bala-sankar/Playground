package educative.backtracking;

public class WordSearch {
    public static boolean wordSearch(char[][] grid, String word) {
        if (grid == null || grid.length == 0) {
            return false;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(grid, r, c, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, int r, int c, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] != word.charAt(index)) {
            return false;
        }
        visited[r][c] = true;
        if (dfs(grid, r + 1, c, word, index + 1, visited) ||
            dfs(grid, r - 1, c, word, index + 1, visited) ||
            dfs(grid, r, c + 1, word, index + 1, visited) ||
            dfs(grid, r, c - 1, word, index + 1, visited)) {
            return true;
        }
        visited[r][c] = false;
        return false;
    }
}
