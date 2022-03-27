package educative;

/*
 Given an array of size n, remove all even integers from it
 Input - arr = {1, 2, 4, 5, 10, 6, 3}
 Output - arr = {1, 5, 3}
 */

import java.util.Arrays;

public class RemoveEven {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 4, 5, 10, 6, 3};
        System.out.println(Arrays.toString(removeEven(arr)));
    }
    public static int[] removeEven(int[] arr) {
        int ptr = 0;
        for(int i : arr) {
            if (i % 2 != 0) {
                arr[ptr] = i;
                ptr++;
            }
        }
        return Arrays.copyOf(arr,ptr);
    }
}
