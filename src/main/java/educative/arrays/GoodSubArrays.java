package educative.arrays;

import java.util.Map;

public class GoodSubArrays {
    /*
    Problem Statement:
    Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, that is, sum = n * k where n is an integer.
    Otherwise, return false.

    Examples:
    Input: nums = [23,2,4,6,7], k = 6
    Output: true
    Explanation: [2, 4] is a continuous subarray of size 2 and sums up to 6.

    Input: nums = [23,2,6,4,7], k = 13
    Output: false

    Input: nums = [2000000000, 2000000000], k = 2000000000
    Output: true
    Explanation: [2000000000, 2000000000] sums to 4000000000, which is a multiple of 2000000000.
    */
    public boolean hasGoodSubarray(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        // Map to store (prefixSum % k) -> earliest index
        Map<Integer, Integer> modMap = new java.util.HashMap<>();
        modMap.put(0, -1); // To handle subarrays starting at index 0
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int mod = k == 0 ? prefixSum : ((prefixSum % k) + k) % k;
            if (modMap.containsKey(mod)) {
                if (i - modMap.get(mod) > 1) {
                    return true;
                }
            } else {
                modMap.put(mod, i);
            }
        }
        return false;
    }

}
