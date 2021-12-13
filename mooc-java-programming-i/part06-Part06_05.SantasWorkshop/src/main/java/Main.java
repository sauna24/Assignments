
public class Main {

    public static void main(String[] args) {
        Gift book = new Gift("harry p", 2);
        Gift book2 = new Gift("harry pp", 20);
        Package gifts = new Package();
        gifts.addGift(book);
        gifts.addGift(book2);
        System.out.println(gifts.totalWeight());
    }
}
