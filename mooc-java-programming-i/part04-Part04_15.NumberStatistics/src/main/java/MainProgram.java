
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        Statistics statisticsEven = new Statistics();
        Statistics statisticsOdd = new Statistics();
        
        Scanner scanner = new Scanner(System.in);
        int numInput = 0;
        System.out.println("Enter numbers:");
        while(true) {
            numInput = Integer.valueOf(scanner.nextLine());
            if(numInput == -1) {
                System.out.println("Sum: " + statistics.sum());
                System.out.println("Sum of even numbers: " + statisticsEven.sum());
                System.out.println("Sum of odd numbers: " + statisticsOdd.sum());
                break;
            }
            statistics.addNumber(numInput);
            if(numInput%2 == 0) {
                statisticsEven.addNumber(numInput);
            } else {
                statisticsOdd.addNumber(numInput);
            }
        }
    }
}
