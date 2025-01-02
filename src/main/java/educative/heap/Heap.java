package educative.heap;

import java.util.PriorityQueue;

public class Heap {
    private void maxHeapify(int[] heapArray, int index, int heapSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && heapArray[left] > heapArray[index]) {
            largest = left;
        }
        if (right < heapSize && heapArray[right] > heapArray[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = heapArray[index];
            heapArray[index] = heapArray[largest];
            heapArray[largest] = temp;
            maxHeapify(heapArray, largest, heapSize);
        }
    }

    public void buildMaxHeap(int[] heapArray, int heapSize)
    {

    }
}
