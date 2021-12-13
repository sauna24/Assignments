
import java.util.Scanner;

public class DivisibleByThree {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int tmp = Integer.valueOf(scanner.nextLine());
//        int tmp2 = Integer.valueOf(scanner.nextLine());
        divisibleByThreeInRange(3, 6);
    }
    public static void divisibleByThreeInRange(int beginning, int end){
        while(true){
            if(beginning > end){
                break;
            }
            if (beginning%3 == 0){
                System.out.println(beginning);
            }
            beginning++;
        }
    }
}
