package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Sibilings {
    public static void main(String[] args) {
        System.out.println(solution(271345687));
//        System.out.println(solution(355));
//        System.out.println(solution(355));
//        System.out.println(solution(-1));
//        System.out.println(solution(355));
//        System.out.println(solution(355));
    }
    public static int solution(int N) {
        // write your code in Java SE 8
        List<Integer> numbers = new ArrayList<>();
        while (N > 0) {
            numbers.add(N % 10);
            N = N / 10;
        }
        return getMaxPermutations(numbers);
    }

    private static int getMaxPermutations(List<Integer> numbers) {
        TreeSet<Integer> permutations = new TreeSet<>();
        int maxNumber = -1;
        permutation(numbers, 0, permutations, numbers.size(), 0);
        int result = permutations.last();
        if (result > 100000000) {
            return -1;
        }
        return permutations.last();
    }
    private static boolean permutation(List<Integer> numbers, Integer num,
                                      TreeSet<Integer> permutations, int length, int loop) {
        if (loop == length) {
            permutations.add(num);
            // Additional logic to avoid timeouts and unnecessary processing.
            return (num > 100000000);
        }
        for (Integer number : numbers) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(numbers);
            temp.remove(number);
            int tempNum = (num * 10) + number;
            if(permutation(temp, tempNum, permutations, length, loop + 1)) {
                return true;
            }
        }
        return false;
    }
}
