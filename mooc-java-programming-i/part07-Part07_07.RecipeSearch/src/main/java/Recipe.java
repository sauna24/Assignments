
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
public class Recipe {
    private String name;
    private int time;
    private ArrayList<String> ingredients = new ArrayList<>();
    
    public Recipe(String name, int time, ArrayList ingredients) {
        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public ArrayList getIngredients() {
        return this.ingredients;
    }
    
    public String toString() {
        return this.name + " , cooking time: " + this.time;
    }
}
