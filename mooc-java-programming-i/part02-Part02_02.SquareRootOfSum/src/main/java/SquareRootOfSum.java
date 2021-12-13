
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.valueOf(scanner.nextLine());
        int input2 = Integer.valueOf(scanner.nextLine());
        int sum = input + input2;
        int squareRoot = (int) Math.sqrt(sum);
        System.out.println(squareRoot);

    }
}
