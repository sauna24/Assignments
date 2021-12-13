
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0.0;
        
        while(true) {
            double input = Integer.valueOf(scanner.nextLine());
            
            if(input == 0) {
                break;
            } else if (input > 0) {
                sum = sum + input;
                count++;
            }
        }

        if (sum == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(sum/count);
        }
    }
}
