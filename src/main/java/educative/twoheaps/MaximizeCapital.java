package educative.twoheaps;

import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int findMaximumCapital(int[] capitals, int[] profits, int numberOfProjects, int initialCapital) {
        int currentCapital = initialCapital;
        int n = capitals.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capitals[i1] - capitals[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(i);
        }
        for (int i = 0; i < numberOfProjects; i++) {
            while (!minCapitalHeap.isEmpty() && capitals[minCapitalHeap.peek()] <= currentCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            currentCapital += profits[maxProfitHeap.poll()];
        }
        return currentCapital;
    }
}
