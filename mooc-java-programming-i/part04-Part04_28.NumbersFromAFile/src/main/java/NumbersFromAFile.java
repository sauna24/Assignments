
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class NumbersFromAFile {

    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("File? ");
        String file = scanner.nextLine();
        
        ArrayList<String> list = new ArrayList<>();
        
        try (Scanner textFile = new Scanner(Paths.get(file))){
            while (textFile.hasNextLine()) {
                list.add(textFile.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Reading the file " + file + " failed.");
        }
        
        System.out.println("Lower bound? ");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        System.out.println("Upper bound? ");
        int upperBound = Integer.valueOf(scanner.nextLine());
        
        for (String item : list) {
            int number = Integer.valueOf(item);
            if (number <= upperBound && number >= lowerBound) {
                count++;
            } 
        }
        System.out.println("Numbers: " + count);
    }

}
