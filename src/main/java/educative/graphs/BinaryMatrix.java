package educative.graphs;

public class BinaryMatrix {
    static int getNumberOfIslands(int[][] binaryMatrix) {
        if (binaryMatrix == null || binaryMatrix.length == 0 || binaryMatrix[0].length == 0) {
            return 0; // No islands if the matrix is empty
        }

        int rows = binaryMatrix.length;
        int cols = binaryMatrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (binaryMatrix[i][j] == 1 && !visited[i][j]) {
                    dfs(binaryMatrix, visited, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private static void dfs(int[][] binaryMatrix, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= binaryMatrix.length || col < 0 || col >= binaryMatrix[0].length ||
            visited[row][col] || binaryMatrix[row][col] == 0) {
            return; // Out of bounds or already visited or water
        }

        visited[row][col] = true; // Mark the cell as visited

        // Explore all 8 directions
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) { // Skip the current cell
                    dfs(binaryMatrix, visited, row + i, col + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] binaryMatrix = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 1},
            {1, 0, 0, 0, 0}
        };

        System.out.println("Number of islands: " + getNumberOfIslands(binaryMatrix)); // Output: Number of islands: 5
    }
}
