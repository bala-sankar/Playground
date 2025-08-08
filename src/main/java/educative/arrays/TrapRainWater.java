package educative.arrays;

/*
Problem Statement:
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Examples:
Input:  [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The elevation map can trap 6 units of water.

Input:  [4,2,0,3,2,5]
Output: 9
Explanation: The elevation map can trap 9 units of water.
*/

public class TrapRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int waterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
            }
        }

        return waterTrapped;
    }
}
