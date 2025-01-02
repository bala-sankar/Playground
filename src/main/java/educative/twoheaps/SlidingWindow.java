package educative.twoheaps;

import java.util.*;

public class SlidingWindow {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        // To store the medians
        List<Double> medians = new ArrayList<Double>();

        // To keep track of the numbers that need to be removed from the heaps
        HashMap<Integer, Integer> outgoingNum = new HashMap<>();

        // Max heap
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());

        // Min heap
        PriorityQueue<Integer> largeList = new PriorityQueue<>();

        // Initialize the max heap
        for (int i = 0; i < k; i++)
            smallList.offer(nums[i]);

        // Transfer the top 50% of the numbers from max heap to min heap
        for (int i = 0; i < k / 2; i++)
            largeList.offer(smallList.poll());

        // Variable to keep the heaps balanced
        int balance = 0;

        int i = k;
        while (true) {
            // If the window size is odd
            if ((k & 1) == 1)
                medians.add((double) (smallList.peek()));
            else
                medians.add((double) ((long)smallList.peek() + (long)largeList.peek()) * 0.5);

            // Break the loop if all elements have been processed
            if (i >= nums.length)
                break;

            // Outgoing number
            int outNum = nums[i - k];

            // Incoming number
            int inNum = nums[i];
            i++;

            // If the outgoing number is from max heap
            if (outNum <= smallList.peek())
                balance -= 1;
            else
                balance += 1;

            // Add/Update the outgoing number in the hash map
            if (outgoingNum.containsKey(outNum))
                outgoingNum.put(outNum, outgoingNum.get(outNum) + 1);
            else
                outgoingNum.put(outNum, 1);

            // If the incoming number is less than the top of the max heap, add it in that heap
            // Otherwise, add it in the min heap
            if (smallList.size() > 0 && inNum <= smallList.peek()) {
                balance += 1;
                smallList.offer(inNum);
            } else {
                balance -= 1;
                largeList.offer(inNum);
            }

            // Re-balance the heaps
            if (balance < 0)
                smallList.offer(largeList.poll());
            else if (balance > 0)
                largeList.offer(smallList.poll());

            // Since the heaps have been balanced, we reset the balance variable to 0.
            // This ensures that the two heaps contain the correct elements for the calculations to be performed on the elements in the next window.
            balance = 0;

            // Remove invalid numbers present in the hash map from top of max heap
            while (smallList.size() > 0 && outgoingNum.containsKey(smallList.peek()) && outgoingNum.get(smallList.peek()) > 0)
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.poll()) - 1);

            // Remove invalid numbers present in the hash map from top of min heap
            while (largeList.size() > 0 && outgoingNum.containsKey(largeList.peek()) && outgoingNum.get(largeList.peek()) > 0)
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.poll()) - 1);
        }

        double[] arr = medians.stream().mapToDouble(Double::doubleValue).toArray();
        return arr;
    }

//    public static double[] medianSlidingWindow(int[] nums, int k) {
//        double[] result = new double[nums.length - k + 1];
//        MedianOfStream medianOfStream = new MedianOfStream();
//        for (int i = 0; i < nums.length; i++) {
//            medianOfStream.insertNum(nums[i]);
//            if (i >= k - 1) {
//                result[i - k + 1] = medianOfStream.findMedian();
//                medianOfStream.removeNum(nums[i - k + 1]);
//            }
//        }
//        return result;
//    }
//
//    static class MedianOfStream {
//        private PriorityQueue<Integer> maxHeap;
//        private PriorityQueue<Integer> minHeap;
//
//        MedianOfStream() {
//            // Write your code here
//            maxHeap = new PriorityQueue<>((a, b) -> b - a);
//            minHeap = new PriorityQueue<>((a, b) -> a - b);
//        }
//
//        public void insertNum(int num) {
//            // Write your code here
//            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
//                maxHeap.add(num);
//            } else {
//                minHeap.add(num);
//            }
//            if (maxHeap.size() > minHeap.size() + 1) {
//                minHeap.add(maxHeap.poll());
//            } else if (maxHeap.size() < minHeap.size()) {
//                maxHeap.add(minHeap.poll());
//            }
//        }
//
//        public double findMedian() {
//            // Replace this placeholder return statement with your code
//            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
//                return 0.0;
//            }
//            if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
//                return (maxHeap.peek() + minHeap.peek()) / 2.0;
//            }
//            return maxHeap.peek();
//        }
//
//        public void removeNum(int num) {
//            if (maxHeap.peek() >= num) {
//                maxHeap.remove(num);
//            } else {
//                minHeap.remove(num);
//            }
//            if (maxHeap.size() > minHeap.size() + 1) {
//                minHeap.add(maxHeap.poll());
//            } else if (maxHeap.size() < minHeap.size()) {
//                maxHeap.add(minHeap.poll());
//            }
//        }
//    }
}
