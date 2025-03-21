public class InsertionSortAppTC{

    public static void sort(int arr[]){
        int key=0;
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            j = i;
 
            while (j > 0 && arr[j-1] > key) {
                arr[j] = arr[j-1];
                j = j -1;
            }
            arr[j] = key;
            printPass(arr, i + 1); //make a call to the printPass method
        }
    }

    public static void printPass(int arr[], int pass) {
        System.out.printf("After Pass %d : ", pass);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; //populate the array
        System.out.println("Original array:");
        for (int i=0; i < arr.length; i++)
            System.out.print(arr[i] +  " ");
            System.out.println();

         sort(arr); //call sort method
    }
}