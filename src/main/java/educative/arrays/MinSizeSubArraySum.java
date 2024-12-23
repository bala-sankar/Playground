package educative.arrays;

/*
Problem Statement#
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest
contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
or [1, 1, 6].
 */
public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        // Check race conditions
        int i = 0, j = 0;
        while(j < arr.length) {
            // Add an element from the window to sum
            windowSum += arr[j];
            while (windowSum >= S && i <= j) {
                // Check min length
                int windowSize = j - i + 1;
                if(windowSize < minLength) {
                    minLength = windowSize;
                }

                // Remove an element from the window to sum
                windowSum -= arr[i];
                i++;
            }
            j++;
        }
        return minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
