
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Give points [0-100]:");
        int first = Integer.valueOf(scan.nextLine());
        
        if (first < 0) {
            System.out.println("impossible!");
        } else if (first < 50){
            System.out.println("failed");
        } else if (first < 60){
            System.out.println("1");
        } else if (first < 70){
            System.out.println("2");
        } else if (first < 80){
            System.out.println("3");
        } else if (first < 90){
            System.out.println("4");
        } else if (first <= 100){
            System.out.println("5");
        } else if (first >= 100){
            System.out.println("incredible!");
        }
    }
}
