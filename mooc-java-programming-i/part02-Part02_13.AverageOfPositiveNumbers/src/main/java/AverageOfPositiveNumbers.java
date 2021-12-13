
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int numOfnums = 0;
        while (true) {
            System.out.println("Give a number:");
            int num = Integer.valueOf(scanner.nextLine());
            if (num == 0) {
                break;
            }
            if (num > 0) {
                count = num + count;
                numOfnums++;
            }

        }
        if (numOfnums == 0) {
            System.out.println("Cannot calculate the average");
        }
        if (numOfnums > 0) {
            double avg = 1.0 * count / numOfnums;
            System.out.println("Average of the numbers: " + avg);
        }
    }
}
