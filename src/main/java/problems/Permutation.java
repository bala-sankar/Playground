package problems;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int [] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        List<Integer> nums = Arrays.asList(1, 4, 5, 6, 7, 8, 9, 0, 1);
        long startTime = System.currentTimeMillis();
        permute(numbers);
        System.out.println("Time for permute = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        Permutation p = new Permutation();
        List<Integer> perms = p.getPermutation(nums);
        System.out.println("Time for getPermutation = " + (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("");
    }


    public static void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
         if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public List<Integer> getPermutation(List<Integer> numbers) {
        List<Integer> permutations = new ArrayList<>();
        permutation(numbers, 0, permutations, numbers.size(), 0);
        return permutations;
    }

    /*
     * Constructs all permutations for given set of numbers
     */
    private void permutation(List<Integer> numbers, Integer num,
                                    List<Integer> permutations, int length, int loop) {
        // Exit condition
        if (loop == length) {
            permutations.add(num);
        }

        for (Integer number : numbers) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(numbers);
            temp.remove(number);
            int tempNum = (num * 10) + number;
            permutation(temp, tempNum, permutations, length, loop + 1);
        }
    }
}
