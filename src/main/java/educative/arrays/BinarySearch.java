package educative.arrays;

/*
We are given an array of integers, nums, sorted in ascending order, and an integer value, target. If the target exists in the array, return its index. If the target does not exist, then return -1.

The binary search divides the input array by half at every step. After every step, either we find the index we are looking for, or we discard half of the array.

Input
nums = [1, 3, 9, 10, 12]
target = 9

Output
2
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 9, 10, 12, 14, 16};
        int target = 9;
        System.out.println(binarySearch(nums, target));
    }

    static int binarySearch(int[] nums, int target) {
        return search(nums,target, 0, nums.length-1);
    }

    static int search(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] == target) {
            return midIndex;
        } else if (nums[midIndex] > target) {
            return search(nums, target, startIndex, midIndex-1);
        } else {
            return search(nums, target, midIndex+1, endIndex);
        }
    }
}
