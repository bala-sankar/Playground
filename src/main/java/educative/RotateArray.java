package educative;

/*
Given an array, can you rotate its elements once from right to left

Input
arr = {1, 2, 3, 4, 5}

Output
arr = {5, 1, 2, 3, 4}
 */
public class RotateArray {
    public static void rotateArray(int[] arr) {
        int lastElement = arr[arr.length-1];
        for (int i = arr.length - 1;  i > 0 ; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = lastElement;
    }
}
