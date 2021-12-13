
import java.util.Scanner;

public class OnlyPositives {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int num = Integer.valueOf(scanner.nextLine());
            if (num == 0) {
                break;
            }
            if (num < 0) {
                System.out.println("Unsuitable number");
                System.out.println("Give a number;");
                continue;
            }
            if (num > 0) {
                System.out.println(num * num);
                System.out.println("Give a number;");
            }
        }
    }
}
