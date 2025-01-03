package educative.greedy;

import java.util.Arrays;

public class RescueBoats {
    public static int rescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }
}
