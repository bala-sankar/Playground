package algorithm;

/**
 * Created by bsankar on 8/9/14.
 */
public class BubbleSort {
    public static void sort(int[] unsortedArray){
        for(int i = 0; i < unsortedArray.length - 1; i++){
            for(int j=unsortedArray.length - 1; j > i; j--){
                if(unsortedArray[j] < unsortedArray[j-1]){
                    //swap
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j-1];
                    unsortedArray[j-1] = temp;
                }
            }
        }
    }
}
