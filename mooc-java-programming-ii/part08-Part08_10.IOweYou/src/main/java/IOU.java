
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimmy
 */
public class IOU {
    
    private HashMap<String, Double> debtMap;
    
    public IOU() {
        this.debtMap = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        this.debtMap.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom){
        return this.debtMap.getOrDefault(toWhom, 0.0);
    }
}
