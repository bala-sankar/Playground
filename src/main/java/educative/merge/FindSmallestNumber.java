package educative.merge;

import java.util.List;
import java.util.PriorityQueue;

public class FindSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (List<Integer> list : lists) {
            for (int num : list) {
                maxHeap.add(num);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(
            List.of(2, 6, 8),
            List.of(3, 7, 10),
            List.of(5, 8, 11)
        );
        System.out.println(kSmallestNumber(lists, 5));
    }
}