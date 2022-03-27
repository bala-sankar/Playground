package educative;

import java.util.Arrays;

/*
Given two sorted arrays, merge them into one array, which should also be sorted.

Sample Input
    arr1 = {1, 3, 4, 5}
    arr2 = {2, 6, 7, 8}
Sample Out put
    arr = {1, 2, 3, 4, 5, 6, 7, 8}
 */
public class MergeArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3, 4, 5};
        int[] arr2 = new int[] {2, 6, 7, 8};
        System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
    }
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        final int resLen = arr1.length + arr2.length;
        int[] result = new int[resLen];
        while( i < arr1.length && j < arr2.length ) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while ( i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while ( j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }
}
