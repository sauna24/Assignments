
import java.util.Scanner;

public class Counting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int num = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i <= num; i++){
            System.out.println(count);
            count++;
        }
    }
}
