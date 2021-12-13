
import java.util.Scanner;

public class SumOfASequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        System.out.println("Last number?");
        int num = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i <= num; i++){
            sum = sum + i;
        }
        System.out.println("The sum is: " + sum);
    }
}
