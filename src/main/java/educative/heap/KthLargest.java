package educative.heap;

import java.util.PriorityQueue;

public class KthLargest {
    public PriorityQueue<Integer> topKHeap;
    public int k;
    // constructor to initialize topKHeap and add values in it
    public KthLargest(int k, int[] nums) {
        this.k = k;
        topKHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    // adds element in the topKHeap
    public int add(int val) {
        topKHeap.add(val);
        if (topKHeap.size() > k) {
            topKHeap.poll();
        }
        return topKHeap.peek();
    }
}
