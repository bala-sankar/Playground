package problems;

import java.util.Arrays;

/*
Given an array, return an array where each index stores the product of all numbers except the number on the index itself.

Input

Output

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
