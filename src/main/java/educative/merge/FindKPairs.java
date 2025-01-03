package educative.merge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairs {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                (l1, l2) -> l1.get(0) + l1.get(1) - l2.get(0) - l2.get(1) );
        for (int num1 : list1) {
            for (int num2 : list2) {
                List<Integer> pair = List.of(num1, num2);
                minHeap.add(pair);

            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!minHeap.isEmpty() && target-- > 0) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] list1 = {9, 8, 2};
        int[] list2 = {6, 3, 1};
        List<List<Integer>> result = kSmallestPairs(list1, list2, 3);
        System.out.println(result);
    }
}
