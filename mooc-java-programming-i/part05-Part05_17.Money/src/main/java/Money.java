
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }
    
    public Money plus(Money addition) {
        Money newMoney = new Money(this.euros + addition.euros, this.cents + addition.cents);
        return newMoney;
    }
    
    public Money minus(Money decreaser){
        int subtractEuro = this.euros - decreaser.euros;
        int subtractCent = this.cents - decreaser.cents;
        
        if (subtractEuro >= 0) {
            if (subtractCent < 0) {
                subtractEuro = subtractEuro - 1;
                subtractCent = subtractCent + 100;
            }
        } else {
            subtractEuro = 0;
            subtractCent = 0;
        }
        Money newMoney = new Money(subtractEuro, subtractCent);
        return newMoney;
    }
    
    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        }
        if (this.euros == compared.euros) {
            if(this.cents < compared.cents) {
                return true;
            }
        }
        return false;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}
