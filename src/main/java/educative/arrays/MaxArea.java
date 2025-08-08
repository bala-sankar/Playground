package educative.arrays;

public class MaxArea {
    public int max_area(int[] heights) {
        // your code goes here
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }
}
