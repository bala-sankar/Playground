package educative.twopointers;

public class MoveZerosToEnd {
    public static int[] moveZerosToEnd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    // Example usage and test cases
    public static void main(String[] args) {
        int[][] testCases = {
            {0, 1, 0, 3, 12},
            {0, 0, 0, 1},
            {1, 2, 3, 4},
            {0, 0, 0, 0},
            {},
            {2, 0, 2, 0, 1}
        };
        for (int[] test : testCases) {
            int[] result = moveZerosToEnd(test.clone());
            System.out.print("Input:  ");
            printArray(test);
            System.out.print("Output: ");
            printArray(result);
            System.out.println();
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
