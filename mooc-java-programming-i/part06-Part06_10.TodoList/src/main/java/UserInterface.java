/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author jimmy
 */
public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;
    
    public UserInterface(TodoList todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }
    
    public void start() {
        
        while(true){
            System.out.println("Command: ");
            String command = scanner.nextLine();
            
            if(command.equals("stop")) {
                break;
            } else if(command.equals("add")){
                System.out.println("To add: ");
                String add = scanner.nextLine();
                todoList.add(add);
            } else if (command.equals("list")) {
                todoList.print();
            } else if (command.equals("remove")) {
                System.out.println("Which one is removed? ");
                int removed = Integer.valueOf(scanner.nextLine());
                todoList.remove(removed);
            }
        }
    }
}
