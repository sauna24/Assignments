
import java.util.Scanner;

public class AverageOfNumbers {

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
        double avg = 1.0 * count / numOfnums;
        System.out.println("Average of the numbers: " + avg);

    }
}
