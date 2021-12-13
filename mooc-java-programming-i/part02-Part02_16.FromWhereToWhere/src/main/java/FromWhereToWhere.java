
import java.util.Scanner;

public class FromWhereToWhere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Where to?");
        int num2 = Integer.valueOf(scanner.nextLine());
        System.out.println("Where from?");
        int num = Integer.valueOf(scanner.nextLine());
        while (num <= num2){
            System.out.println(num);
            num++;
        
        }

    }
}
