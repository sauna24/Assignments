/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimmy
 */
public class Container {
    
    private int currentAmount;
    
    public Container() {
        this.currentAmount = 0;
    }
    
    public int contains() {
        return this.currentAmount;
    }
    
    public void add(int amount) {
        if (amount > 0) {
            if ((this.currentAmount + amount) > 100) {
                this.currentAmount = 100;
            } else {
                this.currentAmount += amount;
            }
        }
    }
    
    public void remove(int amount) {
        if(amount >= 0) {
            if((this.currentAmount - amount) <= 0) {
                this.currentAmount = 0;
            } else {
                this.currentAmount -= amount;
            }
        }
    }
    
    public String toString() {
        return this.currentAmount + "/100";
    }
}
