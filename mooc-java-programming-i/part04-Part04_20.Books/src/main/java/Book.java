/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimmy
 */
public class Book {
    private String title;
    private String noOfPages;
    private String publYear;
    
    public Book (String title, String noOfPages, String publYear) {
        this.title = title;
        this.noOfPages = noOfPages;
        this.publYear = publYear;
    }
    
    public String getName() {
        return title;
    }
    public String toString() {
        return this.title + ", " + this.noOfPages + " pages, " + this.publYear;
    }
}
