/* This code is complete 
 * Time should be spend understanding this code.
 * Change the contents of the array and see what happens
 * Include additional print statements to assist understanding of each step of the algorithm.
 */

import java.util.Arrays;
public class MergeSortApp{
 
    public static void divide(int[] numbers) {
        int len = numbers.length;

        if (len <=1) {
                System.out.println("Satisfied base case, array is length:" + len);
          return;
        }

        int midIndex = len / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[len - midIndex];

        for (int i = 0; i < midIndex; i++) {
          leftHalf[i] = numbers[i];
        }
        for (int i = midIndex; i < len; i++) {
          rightHalf[i - midIndex] = numbers[i];
        }

        System.out.println("leftHalf array: " + Arrays.toString(leftHalf));
        System.out.println("rightHalf array: " + Arrays.toString(rightHalf));
        divide(leftHalf);
        divide(rightHalf);


        System.out.println("Left half before merge " + Arrays.toString(leftHalf));
        System.out.println("Right half before merge " + Arrays.toString(rightHalf));
        merge(numbers, leftHalf, rightHalf);
    }

    public static void merge (int[] numbers, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
    
        int i = 0, j = 0, k = 0;
    
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                numbers[k] = leftHalf[i];
                i++;
            }
            else {
                numbers[k] = rightHalf[j];
                j++;
            }
            k++;
        }
    
        while (i < leftSize) {
            numbers[k] = leftHalf[i];
            i++;
            k++;
        }
    
        while (j < rightSize) {
            numbers[k] = rightHalf[j];
            j++;
            k++;
        }
        System.out.println("numbers " + Arrays.toString(numbers));
    }

    public static void main(String[] args) {

        int arr[] = {13, 4, 24, 10, 3, 33, 28, 52, 6};

        System.out.println("Before:");
        printArray(arr);

        divide(arr); 

        System.out.println("After:");
        printArray(arr);
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
}