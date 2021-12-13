
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PointsAndGrades pointsAndGrades = new PointsAndGrades();
        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(pointsAndGrades, scanner);
        ui.start();
        // Write your program here -- consider breaking the program into 
        // multiple classes.
    }
}
