
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int output = 0;
        
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                output = numbersCubed(Integer.valueOf(input));
                System.out.println(output);
            }
        }
        
    }
    
    public static int numbersCubed(int number) {
        return number * number * number;
    }
}
