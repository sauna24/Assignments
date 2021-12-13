
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
public class TodoList {
    private ArrayList<String> toDo;
    
    public TodoList() {
        this.toDo = new ArrayList<>();
    }
    
    public void add(String task) {
        this.toDo.add(task);
    }
    
    public void print() {
        for(String todo : toDo) {
        System.out.println((toDo.indexOf(todo) + 1) + ": " + todo);
        }
    }
    
    public void remove(int number) {
        this.toDo.remove(number - 1);
    }
}
