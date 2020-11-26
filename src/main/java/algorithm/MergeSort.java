package algorithm;

/**
 * Created by bsankar on 8/9/14.
 */
public class MergeSort {
    public static void sort(int[] unsortedArray){
        mergeSort(unsortedArray, 0, unsortedArray.length - 1);
    }

    private static void mergeSort(int[] unsortedArray, int startIndex, int endIndex){
        if (startIndex < endIndex) {
            int splitIndex = (startIndex + endIndex) / 2;
            mergeSort(unsortedArray, startIndex, splitIndex);
            mergeSort(unsortedArray, splitIndex + 1, endIndex);
            merge(unsortedArray, startIndex, splitIndex, endIndex);
        }
    }

    private static void merge(int[] unsortedArray, int startIndex, int splitIndex, int endIndex){
        int leftArrayLimit = splitIndex - startIndex + 1;
        int rightArrayLimit = endIndex - splitIndex;
        int[] leftArray = new int[leftArrayLimit + 1];
        int[] rightArray = new int[rightArrayLimit + 1];
        //Initialize left and right array
        for(int index = 0; index < leftArrayLimit; index++){
            leftArray[index] = unsortedArray[startIndex + index];
        }
        for(int index = 0; index < rightArrayLimit; index++){
            rightArray[index] = unsortedArray[splitIndex + 1 + index];
        }
        leftArray[leftArrayLimit] = Integer.MAX_VALUE;
        rightArray[rightArrayLimit] = Integer.MAX_VALUE;

        int leftArrayIndex = 0, rightArrayIndex = 0;

        for(int index = startIndex; index <= endIndex; index++){
            if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]){
                unsortedArray[index] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                unsortedArray[index] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
        }
    }
}

