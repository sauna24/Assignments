
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longest = 0;
        String name = "";
        String longestName = "";
        int counter = 0;
        int byear = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] pieces = input.split(",");

            name = pieces[0];

            if (longestName.length() < name.length()) {
                longestName = pieces[0];
            }
            counter++;
            byear += Integer.valueOf(pieces[1]); 
        }
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + 1.0* byear/counter);
    }
}
