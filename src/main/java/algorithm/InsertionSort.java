package algorithm;

/**
 * Created by bsankar on 8/8/14.
 */
public class InsertionSort {
    public static void sort(int[] unsortedArray){
        for(int i = 1; i < unsortedArray.length; i++){
            int key = unsortedArray[i];
            int j;
            for(j = i-1; j >= 0 && unsortedArray[j] > key ; j--){
                //move the numbers
                unsortedArray[j + 1] = unsortedArray[j];
            }
            unsortedArray[j + 1] = key;
        }
    }
}
