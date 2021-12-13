
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Main {

    public static void main(String[] args) {
        // insert test code here
        int[] array = {3, 1, 5, 99, 3, 12};
    }
    
    // static method to sort array of integers
    public static void sort(int[] array) {
        Arrays.sort(array);
    }

    // static method to sort array of strings
    public static void sort(String[] array) {
        Arrays.sort(array);
    }
    
    // static method to sort ArrayList of numbers
    public static void sortIntegers(ArrayList<Integer> numbers){
        Collections.sort(numbers);
    }
    
    // static method to sort ArrayList of strings
    public static void sortStrings(ArrayList<String> strings){
        Collections.sort(strings);
    }
}
