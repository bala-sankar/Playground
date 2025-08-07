package educative.twopointers;

import java.util.Arrays;

public class SumOfThree {
    public static boolean findSumOfThree(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (findPair(nums, target - nums[i], i + 1)) {
                return true;
            }
        }
        return false;
    }

    static boolean findPair(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
