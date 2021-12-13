
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        System.out.println("First number?");
        int num1 = Integer.valueOf(scanner.nextLine());
        System.out.println("Last number?");
        int num2 = Integer.valueOf(scanner.nextLine());
        for (int i = num1; i <= num2; i++){
            sum = sum + i;
        }
        System.out.println("The sum is: " + sum);
    }
}
