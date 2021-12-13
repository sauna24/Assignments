
import java.util.Scanner;

public class AVClub {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] pieces = input.split(" ");
            for (String words : pieces) {
                if (words.contains("av")) {
                    System.out.println(words);
                }
            }
        }
        
    }
}
