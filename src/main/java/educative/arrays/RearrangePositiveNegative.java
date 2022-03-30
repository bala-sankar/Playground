package educative.arrays;

/*
Given an array, can you re-arrange its elements in such a way that the negative elements appear at one side and positive elements appear at the other?
Note: Consider 0 as a positive number.

Input
arr = {10, -1, 20, 4, 5, -9, -6}

Output
arr = {-1, -9, -6, 10, 20, 4, 5}

 */
public class RearrangePositiveNegative {
    public static void reArrange(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (true) {
            while (i < arr.length && arr[i] < 0) {
                i++;
            }

            while (j >= 0 && arr[j] >= 0) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
        }
    }
}
