
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }

            list.add(input);
        }
        int searchForNumber = 0;
        System.out.println("Search for?");
        searchForNumber = Integer.valueOf(scanner.nextLine());
        
        for(int i = 0; i < list.size(); i++){
            int tmp = list.get(i);
            if(tmp == searchForNumber){
                System.out.println(searchForNumber + " is at index " + i);
            }
        }
        // implement here finding the indices of a number
    }
}
