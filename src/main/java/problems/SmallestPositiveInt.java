package problems;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SmallestPositiveInt {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new TreeSet<>();
        for (int a: A) {
            set.add(a);
        }
        int result = 1;
        for (int val: set) {
            if (val < result) {
                continue;
            } else if (val == result) {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int minPositiveInt = 1;

        for (int a :  A) {
            if (a < minPositiveInt) {
                continue;
            } else if (a == minPositiveInt) {
                minPositiveInt++;
            } else {
                return minPositiveInt;
            }
        }

        return minPositiveInt;
    }
}
