
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Value of the gift?");
        double value = Double.valueOf(scan.nextLine());
        if(value <= 5000){
            System.out.println("No tax!");
        }
        if(value >= 5000 && value < 25000){
            value = 100 + (value - 5000) * 0.08;
        }
        if(value >= 25000 && value < 55000){
            value = 1700 + (value - 25000) * 0.10;
        }
        if(value >= 55000 && value < 200000){
            value = 4700 + (value - 55000) * 0.12;
        }
        if(value >= 200000 && value < 1000000){
            value = 22100 + (value - 200000) * 0.15;
        }
        if(value >= 1000000 ){
            value = 142100 + (value - 1000000) * 0.17;
        }
        System.out.println("Tax: " + value);
    }
}
