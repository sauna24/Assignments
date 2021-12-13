import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Title: ");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                break;
            }
            System.out.println("Pages: ");
            String pages = scanner.nextLine();
            System.out.println("Publication year: ");
            String publYear = scanner.nextLine();
            
            books.add(new Book(title, pages, publYear));
        }
        System.out.println("What information will be printed? ");
        String input = scanner.nextLine();
        
        if (input.contains("everything")) {
            for (Book book : books) {
                System.out.println(book);
            }
        }
        if (input.contains("name")) {
            for (Book book : books) {
                System.out.println(book.getName());
            }
        }

    }
}
