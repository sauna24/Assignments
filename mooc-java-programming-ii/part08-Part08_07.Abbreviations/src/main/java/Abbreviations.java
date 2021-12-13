
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
public class Abbreviations {
    private HashMap<String, String> abbrevationMap;
    
    public Abbreviations () {
        this.abbrevationMap = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        this.abbrevationMap.put(abbreviation, explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return this.abbrevationMap.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        return this.abbrevationMap.get(abbreviation);
    }
}
