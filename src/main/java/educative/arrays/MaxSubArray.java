package educative.arrays;

/*
Given an array, find the sum of contiguous subarray with the largest sum.

Input
arr = {1, 7, -2, -5, 10, -1}

Output
11
 */
public class MaxSubArray {
    int findMaxSumSubArray(int[] arr) {
        if (arr.length < 0) {
            return 0;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i - 1] + arr[i], arr[i]);
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }

}
