
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimmy
 */
public class TextUI {
    private Scanner scanner;
    private SimpleDictionary simpleDictionary;
    
    public TextUI(Scanner scanner, SimpleDictionary simpleDictionary){
        this.simpleDictionary = simpleDictionary;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.println("Command: ");
            String command = scanner.nextLine();
            if(command.equals("end")){
                System.out.println("Bye bye!");
                break;
            } else if (command.equals("add")) {
                System.out.println("Word:");
                String word = scanner.nextLine();
                System.out.println("Translation:");
                String translation = scanner.nextLine();
                simpleDictionary.add(word, translation);            
            } else if (command.equals("search")) {
                System.out.println("To be translated: ");
                String search = scanner.nextLine();
                String returnSearch = simpleDictionary.translate(search);
                if (returnSearch == null) {
                    System.out.println("Word " + search + " was not found");
                } else {
                    System.out.println(returnSearch);
                }
            }
            System.out.println("Unknown command");
        }
    }
}
