
import java.util.Arrays;


public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
//        int[] array = {3, 1, 5, 99, 3, 12};
//        System.out.println("Smallest: " + MainProgram.smallest(array));

//int[] numbers = {6, 5, 8, 7, 11};
//System.out.println("Index of the smallest number: " + MainProgram.indexOfSmallest(numbers));

//int[] numbers = {-1, 6, 9, 8, 12};
//System.out.println(MainProgram.indexOfSmallestFrom(numbers, 0));
//System.out.println(MainProgram.indexOfSmallestFrom(numbers, 1));
//System.out.println(MainProgram.indexOfSmallestFrom(numbers, 2));

//int[] numbers = {3, 2, 5, 4, 8};
//
//System.out.println(Arrays.toString(numbers));
//
//MainProgram.swap(numbers, 1, 0);
//System.out.println(Arrays.toString(numbers));
//
//MainProgram.swap(numbers, 0, 3);
//System.out.println(Arrays.toString(numbers));

int[] numbers = {8, 3, 7, 9, 1, 2, 4};
MainProgram.sort(numbers);
    }
    
    public static int smallest(int[] array) {
        int smallest = array[0];
        for(int number : array) {
            if(number < smallest) {
                smallest = number;
            }
        }
        return smallest;
    }
    
    public static int indexOfSmallest(int[] array) {
       int smallest = MainProgram.smallest(array);
       int index = 0;
       
       for(int i = 0; i < array.length; i++) {
           if (array[i] == smallest) {
               index = i;
           }
       }
       return index;
    }
    
    public static int indexOfSmallestFrom(int[] array, int startIndex) {
        int index = startIndex;
        int smallest = array[index];

        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }

        return index;
    }
    
    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp; 
    }
    
    public static void sort(int[] array) {
        int index = 0;
        System.out.println(Arrays.toString(array));

        while (index < array.length) {
            
            swap(array, index, indexOfSmallestFrom(array, index));
            System.out.println(Arrays.toString(array));
            
            index += 1;
        }   
    }
}
