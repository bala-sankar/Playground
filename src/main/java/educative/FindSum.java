package educative;

import java.util.Arrays;

/*
Given an array and a number "n", find two numbers from the array that sums up to "n".

Input
    arr = {1, 21, 3, 14, 5, 60, 7, 6}
    value = 27

Output
    arr = {21, 6} or {6, 21}
 */
public class FindSum {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 21, 3, 14, 5, 60, 7, 6};
        int n = 27;
        System.out.println(Arrays.toString(findSum(arr, n)));
        System.out.println(Arrays.toString(findSumSortMethod(arr, n)));
    }

    public static int[] findSum(int[] arr, int n) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ( arr[i] + arr[j] == n) {
                    return new int[] { arr[i], arr[j] };
                }
            }
        }
        return arr;
    }

    public static int[] findSumSortMethod(int[] arr, int n) {
        Arrays.sort(arr);
        int i = 0, j =  arr.length - 1;
        while (i != j) {
            int sum = arr[i] + arr[j];

            if (sum < n) {
                i++;
            } else if (sum > n) {
                j--;
            } else {
                return new int[] {arr[i], arr[j]};
            }
        }
        return arr;
    }

}
