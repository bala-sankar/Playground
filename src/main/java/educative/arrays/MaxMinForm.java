package educative.arrays;

/*
Given an array, can you re-arrange the elements such that the first position will have the largest number, the second will have the smallest, the third will have the second-largest, and so on.
Note: The given array is sorted in ascending order.
Note: The range of integers in the array can be from 0 to 10000.


 */
public class MaxMinForm {
    void maxMin(int[] arr) {
        int[] result = new int[arr.length];
        int k = 0;
        int i, j;
        for (i = 0, j = arr.length - 1; i < j; i++, j--) {
            result[k] = arr[j];
            result[k+1] = arr[i];
            k = k + 2;
        }
        if (i == j) {
            result[k] = arr[i];
        }
        for (i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

}
