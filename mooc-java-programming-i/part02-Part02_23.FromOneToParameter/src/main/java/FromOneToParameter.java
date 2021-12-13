
import java.util.Scanner;



public class FromOneToParameter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.valueOf(scanner.nextLine());
        printUntilNumber(input);

    }
    public static void printUntilNumber( int number) {
        int count = 1;
        while (number > 0){
            System.out.println(count);
            count++;
            number--;
        }
    }
}
