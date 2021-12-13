
public class Main {

    public static void main(String[] args) {
//        PaymentCard petesCard = new PaymentCard(10);
//        
//        System.out.println("£" + petesCard.balance());
//        boolean wasSuccessful = petesCard.takeMoney(8);
//        System.out.println("Sucessfully withdrew: " + wasSuccessful);
//        System.out.println("money: " + petesCard.balance());
//        
//        wasSuccessful = petesCard.takeMoney(4);
//        System.out.println("Sucessfully withdrew: " + wasSuccessful);
//        System.out.println("money: " + petesCard.balance());

        PaymentTerminal unicafeExactum = new PaymentTerminal();
        
        double change = unicafeExactum.eatAffordably(10);
        System.out.println("remaining: " + change);
        
        PaymentCard annesCard = new PaymentCard(7);
        
        boolean wasSuccessful = unicafeExactum.eatHeartily(annesCard);
        System.out.println("there was enough money " + wasSuccessful);
        wasSuccessful = unicafeExactum.eatHeartily(annesCard);
        System.out.println("there was enough money " + wasSuccessful);
        wasSuccessful = unicafeExactum.eatAffordably(annesCard);
        System.out.println("there was enough money " + wasSuccessful);
        
        System.out.println(unicafeExactum);
    }
}

