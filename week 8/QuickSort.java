/*
1.
Modify the partition method so it uses a random pivot rather than the
right-most element.

Simply pick a random index in the array and swap it with the right-most 
element. 

follow the normal partition pseudocode relying on the right-most element. 

To pick a random number, use the random method to return an integer
between 0 and the one less than the length of the array.

2.
The second change to the class is to allow the user to specify whether 
they wish to sort in ascending or descending order.
*/ 
 /* added this*/

class QuickSort{
      
    static void swap(int[] arr, int i, int j){
        System.out.println("swapping " + arr[i] + " " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
 /* added boolean ascending)*/

    static int partition(int[] arr, int low, int high, boolean ascending){
        
        /* add random  */
        //random pivot selection
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);


        int pivot = arr[high]; 
        System.out.println("The pivot is " + pivot);
           
        int i = (low - 1); 
           
        for(int j = low; j <= high - 1; j++){
            System.out.println("Compare " + arr[j] + " pivot " + pivot);
          
            /* if (arr[j] < pivot){
                i++; 
                swap(arr, i, j);
                printArray(arr);
            }
        } */

        //ADDED 
        if ((ascending && arr[j] < pivot) || (!ascending && arr[j] > pivot)) {
            i++; 
            swap(arr, i, j);
            printArray(arr);
        }
    }


        System.out.println("Insert pivot in correct location");
        swap(arr, i + 1, high);
        printArray(arr);
        return (i + 1);
    }
  
    static void quickSort(int[] arr, int low, int high, boolean ascending){
        if (low >= high){
            System.out.println("End recurssive call");
            return;
        }
        else{ //added ascending
            int pivotIndex = partition(arr, low, high, ascending);
    
            System.out.println("Left Recurssive Call");
            System.out.println("LRC with low " + low + " high " + (pivotIndex-1));
            quickSort(arr, low, pivotIndex - 1, ascending);

            System.out.println("Right Recursive Call");
            System.out.println("RRC with low " + (pivotIndex + 1) + " high " + high);            
            quickSort(arr, pivotIndex + 1, high, ascending);    
        }
    }

    static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //overloaded method for default ascending sort
    static void quickSort(int[] arr, int low, int high) {
        quickSort(arr, low, high, true);
    }    
    
    public static void main(String[] args){
        int[] arr = {12, 2, 24, 6, 26, 8};
         
        System.out.println("Before sort: -ascending");
        printArray(arr);
        System.out.println("*********************");
        quickSort(arr, 0, arr.length - 1, true); //TRUE for ascending
        System.out.println("*********************");
        System.out.println("Sorted array: -ascending");
        printArray(arr);

        //added this
        int[] arr2 = {12, 2, 24, 6, 26, 8};
        System.out.println("\nBefore sort (descending): ");
        printArray(arr2);
        System.out.println("*********************");
        quickSort(arr2, 0, arr2.length - 1, false); //FALSE for descending
        System.out.println("*********************");
        System.out.println("Sorted array (descending): ");
        printArray(arr2);
    }
}
  