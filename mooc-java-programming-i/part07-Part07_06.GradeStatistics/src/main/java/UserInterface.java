
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimmy
 */
public class UserInterface {
    
    private PointsAndGrades pointsAndGrades;
    private Scanner scanner;
    
    public UserInterface(PointsAndGrades pointsAndGrades, Scanner scanner) {
        this.pointsAndGrades = pointsAndGrades;
        this.scanner = scanner;
    }
    
    public void start() {
        readPoints();
        printAverage();
        printPointAveragePassingGrade();
        printPassPercentage();
        printGradeDistribution();
    }
    
    public void readPoints() {
        System.out.println("Enter point totals, -1 stops:");
        while(true) {
            
            int command = Integer.valueOf(scanner.nextLine());
            if(command == -1){                
                break;
            }
           
            this.pointsAndGrades.addPoints(command);

        }  
    }
    
    public void printAverage() {
        System.out.println("Point average (all): " + pointsAndGrades.pointAverage());
    }
    
    public void printPointAveragePassingGrade() {
        String nonePassing = "-";
        
        if (pointsAndGrades.pointAveragePassingGrade() == -1) {
            System.out.println("Point average (passing): " + nonePassing);
        } else {
            System.out.println("Point average (passing)" + pointsAndGrades.pointAveragePassingGrade());
        }
    }
    
    public void printPassPercentage() {
        System.out.println("Pass percentage: " + pointsAndGrades.passPercentage());
    }
    
    public static void printStars(int stars) {
        while(stars > 0) {
            System.out.print("*");
            stars--;
        }
    }
    
    public void printGradeDistribution() {
        System.out.println("Grade distribution:");
        int grade = 5;
        
        while(grade >= 0) {
            int stars = pointsAndGrades.totalGradesInPoints(grade);
            System.out.print(grade + ": ");
            printStars(stars);
            System.out.println("");
            
            grade--;
        }
    }
}
