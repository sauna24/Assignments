
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int oldest = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] pieces = input.split(",");

            int age = Integer.valueOf(pieces[1]);

            if (oldest < age) {
                oldest = Integer.valueOf(pieces[1]);

            }
        }
        System.out.println("Age of the oldest: " + oldest);
    }
}
