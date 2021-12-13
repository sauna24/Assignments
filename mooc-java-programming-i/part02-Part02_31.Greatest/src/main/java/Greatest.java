
public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        int tmp = Math.max(number1, Math.max(number2, number3));
        return tmp;
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}
