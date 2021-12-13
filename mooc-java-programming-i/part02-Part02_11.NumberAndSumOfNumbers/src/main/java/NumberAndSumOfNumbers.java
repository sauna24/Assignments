
import java.util.Scanner;

public class NumberAndSumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int numOfnums = 0;
        while (true){
            System.out.println("Give a number:");
            int num = Integer.valueOf(scanner.nextLine());
            if (num == 0){
                break;
            }
            count = num + count;
            numOfnums++;
        }
        System.out.println("Number of numbers: " + numOfnums);
        System.out.println("Sum of the numbers: " + count);
    }
}
