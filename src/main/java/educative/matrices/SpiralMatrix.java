package educative.matrices;

import java.util.ArrayList;
import java.util.List;

/*
Input [[3,1,1],[15,12,13],[4,14,12],[10,5,11]]

 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = -1;
        int direction = 1;
        List<Integer> result = new ArrayList<>();

        while (rows > 0 && cols > 0) {
            for (int i = 0; i < cols; i++) {
                col += direction;
                result.add(matrix[row][col]);
            }
            rows--;

            for (int i = 0; i < rows; i++) {
                row += direction;
                result.add(matrix[row][col]);
            }
            cols--;

            direction *= -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,1,1},{15,12,13},{4,14,12},{10,5,11}};
        System.out.println(spiralOrder(matrix));
    }
}
