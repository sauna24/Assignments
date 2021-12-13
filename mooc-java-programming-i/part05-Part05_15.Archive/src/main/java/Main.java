
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Archive> archives = new ArrayList<>();
        
        while (true) {
            System.out.println("Identifier (empty will stop)");
            String identifier = scanner.nextLine();
            if (identifier.isEmpty()) {
                break;
            }

            System.out.println("Name?(empty will stop)");
            String name = scanner.nextLine();
            
            if (name.isEmpty()) {
                break;
            }
            
            Archive archive = new Archive(identifier, name);
            if (archives.contains(archive)) { // contains kallar equals i Archive 
                continue;
            } else {
            archives.add(archive); 
            }
        }
        
        System.out.println("==Items==");
        for (Archive entry : archives) {
            System.out.println(entry.getIdentifier() + ": " + entry.getName());
        }

    }
}
