
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {
        int sum = 0;
        int numOfn = 0;
        double avg = 0.0;
        int even = 0;
        int odd = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give numbers:");
        while(true){

            int input = Integer.valueOf(scanner.nextLine());
            if(input == -1){
                System.out.println("Thx! Bye!");
                break;
            }
            if(input%2 == 0){
                even++;
            } else {
                odd++;
            }
            sum = sum + input;  
            numOfn++;
            avg = 1.0 * sum/numOfn;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + numOfn);
        System.out.println("Average: " + avg);
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
