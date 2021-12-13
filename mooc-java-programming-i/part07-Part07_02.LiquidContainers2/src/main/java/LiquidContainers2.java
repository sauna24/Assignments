
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//
//        while (true) {
//            System.out.print("> ");
//
//            String input = scan.nextLine();
//            if (input.equals("quit")) {
//                break;
//            }
//
//        }

            Container firstContainer = new Container();
            Container secondContainer = new Container();
            Scanner scanner = new Scanner(System.in);

            UserInterface ui = new UserInterface(firstContainer, secondContainer, scanner);
            ui.start();
    }

}
