package educative.arrays;

import java.util.Arrays;

/*
Problem Statement:
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

Examples:
Input:  [1, 2, 3, 4]
Output: [24, 12, 8, 6]

Input:  [2, 0, 2, 0, 1]
Output: [0, 0, 0, 0, 0]

Input:  [0, 1, 2, 3]
Output: [6, 0, 0, 0]
*/
public class ArrayOfProducts {
    public static void main(String[] args) {

    }

    public static int[] findProduct(int[] arr) {
        int product = 1;
        int[] result = new int[arr.length];
        int zeroIndex = -1;
        int zeroElements = 0;
        for (int i : arr) {
            if (i == 0) {
                zeroIndex = i;
                zeroElements++;
            } else {
                product = product * i;
            }
        }

        // If more than one element is zero in an array, then the result is all 0s
        if (zeroElements > 1) {
            Arrays.fill(result, 0);
        } else if( zeroElements == 1) {
            // If one element is zero, every element is zero except one
            Arrays.fill(result, 0);
            result[zeroIndex] = product;
        } else {
            for (int j = 0; j < arr.length; j++) {
                result[j] = product / arr[j];
            }
        }
        return result;
    }

}
