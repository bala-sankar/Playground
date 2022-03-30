package educative.arrays;

/*
Given an array of size n, can you find the second maximum element in the array
Assumption: Array should contain at least two unique elements.

Input
arr = {9,2,3,6}

Output
6
 */
public class SecondMaximum {
    public static int findSecondMaximum(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i : arr) {
            if ( i > max1) {
                max2 = max1;
                max1 = i;
            } else if ( i > max2 && i != max1) {
                max2 = i;
            }
        }
        return max2;
    }

}
