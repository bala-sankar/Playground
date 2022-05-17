package algorithm;

/**
 * Created by bsankar on 8/9/14.
 */
public class HeapSort {
    public static void sort(int[] unsortedArray){
/*
1 BUILD-MAX-HEAP.A/
2 for i D A:length downto 2
3 exchange AŒ1 with AŒi
4 A:heap-size D A:heap-size  1
5 MAX-HEAPIFY.A; 1/

 */
    }

    public int parentNode(int childNode){
        return childNode/2;
    }

    public int leftChildNode(int parentNode){
        return parentNode * 2;
    }

    public int rightChildNode(int parentNode){
        return (parentNode * 2) + 1;
    }

    public void maxHeapify(int[] unsortedArray, int parentNode){
        int leftChildNode = leftChildNode(parentNode);
        int rightChildNode = rightChildNode(parentNode);
        int largestNode = parentNode;
        if(leftChildNode <= unsortedArray.length && unsortedArray[leftChildNode] > unsortedArray[parentNode]){
            largestNode = leftChildNode;
        }
        if(rightChildNode <= unsortedArray.length && unsortedArray[rightChildNode] > unsortedArray[parentNode]){
            largestNode = rightChildNode;
        }
        if(largestNode != parentNode){
            int temp = unsortedArray[parentNode];
            unsortedArray[parentNode] = unsortedArray[largestNode];
            unsortedArray[largestNode] = temp;
            maxHeapify(unsortedArray, largestNode);
        }
    }

    public void buildMaxHeap(int[] unsortedArray){
        for (int node = unsortedArray.length/2; node <=0; node++){
            maxHeapify(unsortedArray, node);
        }
    }
}
