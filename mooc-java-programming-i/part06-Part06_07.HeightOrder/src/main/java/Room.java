
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
public class Room {
    private ArrayList<Person> persons;
    
    public Room () {
        this.persons = new ArrayList<>();
    }
    
    public void add(Person person) {
        this.persons.add(person);
    }
    
    public boolean isEmpty() {
        return this.persons.isEmpty();
    }
    
    public ArrayList<Person> getPersons() {
        return this.persons;
    }
    
    public Person shortest() {
        if (this.persons.isEmpty()) {
            return null;
        }
        
        Person returnShortestObject = this.persons.get(0);
        
        for (Person shortest : this.persons) {
            if (returnShortestObject.getHeight() > shortest.getHeight()) {
                returnShortestObject = shortest;
            }
        }
        return returnShortestObject;
    }
    
    public Person take() {
        Person shortestPerson = shortest();    // använder metoden shortest för att 
        this.persons.remove(shortestPerson);   // hämta värdet på kortaste personen
        return shortestPerson;
    }
}
