package problems;

import java.util.HashMap;
import java.util.Map;

/*
Given an array, find the first integer, which is unique in the array. Unique means the number does not repeat and appears only once in the whole array.
In this problem, you have to implement the int findFirstUnique(int[] arr) method that will look for a first unique integer, which appears only once in the whole array. The function returns -1 if no unique number is found.

Input
arr = {9, 2, 3, 2, 6, 6}

Output
9
 */
public class FindFirstUnique {
    public static int findFirstUnique(int[] arr) {
        Map<Integer, Boolean> isUniqueInteger = new HashMap<Integer, Boolean>();
        for (int i : arr) {
            if (isUniqueInteger.keySet().contains(i)) {
                isUniqueInteger.put(i, Boolean.FALSE);
            } else {
                isUniqueInteger.put(i, Boolean.TRUE);
            }
        }

        for (int i : arr) {
            if (isUniqueInteger.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
