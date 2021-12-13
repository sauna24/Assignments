
import java.util.Scanner;

public class ComparingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.valueOf(scanner.nextLine());
        int input2 = Integer.valueOf(scanner.nextLine());
        if(input > input2){
            System.out.println(input + " is greater than " + input2);
        } else if (input < input2){
            System.out.println(input + " is smaller than " + input2);
        } else {
            System.out.println(input + " is equal to " + input2);
        }
    }
}
