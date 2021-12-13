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
public class Suitcase {
    private int maximumWeight;
    private ArrayList<Item> suitcase;
    
    public Suitcase(int maximumWeight){
        this.maximumWeight = maximumWeight;
        this.suitcase = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        if (this.totalWeight() + item.getWeight() <= this.maximumWeight) {
            this.suitcase.add(item);
        }
    }
    
    public int totalWeight() {
        int currentWeight = 0;
        for (Item item : suitcase) {
            currentWeight += item.getWeight();
        }
        return currentWeight;
    }
    
    public void printItems() {
        for(Item item : suitcase) {
            System.out.println(item);
        }
    }
    
    public Item heaviestItem() {
        if (this.suitcase.isEmpty()) {
            return null;
        }
        
        Item returnHeaviestItem = this.suitcase.get(0);
        
        for(Item heaviest : this.suitcase) {
            if (returnHeaviestItem.getWeight() < heaviest.getWeight()) {
                returnHeaviestItem = heaviest;
            }
        }
        return returnHeaviestItem;
    }

    public String listItems(){
        
        String listItems =  "";
        
        for(Item item : suitcase){
            listItems += item.toString() + "\n";
        }
        
        return listItems;
    }    
    @Override
    public String toString() {
        String suitcaseString = "";
        
        if(suitcase.isEmpty()) {
            suitcaseString = "no items (0 kg)";
        }
        else if (suitcase.size() == 1) {
            suitcaseString = this.suitcase.size() + " item (" + this.totalWeight() + " kg)";
        } else {
            suitcaseString = this.suitcase.size() + " items (" + this.totalWeight() + " kg)";
        }
        
        return suitcaseString;
    }
    

}
