package educative.twopointers;

public class SortColors {
    public static int[] sortColors (int[] colors) {

        // Write your code here
        int start = 0;
        int current = 0;
        int end = colors.length - 1;
        while (current <= end) {
            int temp;
            if(colors[current] == 0) {
                temp = colors[current];
                colors[current] = colors[start];
                colors[start] = temp;
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            } else if (colors[current] == 2) {
                temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;
                end--;
            }
        }
        return colors;
    }
}
