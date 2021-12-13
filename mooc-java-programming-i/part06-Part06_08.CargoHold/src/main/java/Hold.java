
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimmy
 */
public class Hold {
    private int maximumWeight;
    private ArrayList<Suitcase> hold;
    
    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.hold = new ArrayList<>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeight() + suitcase.totalWeight() <= this.maximumWeight) {
            this.hold.add(suitcase);
        }
    } 
    
    public int totalWeight() {
        int currentWeight = 0;
        for (Suitcase item : hold) {
            currentWeight += item.totalWeight();
        }
        return currentWeight;
    }
    
    public void printItems() {
        for (Suitcase suitcase : hold) {
            System.out.print(suitcase.listItems());

        }
    }
    public String toString() {
        return this.hold.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}
