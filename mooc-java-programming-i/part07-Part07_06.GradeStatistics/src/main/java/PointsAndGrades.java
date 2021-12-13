
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
public class PointsAndGrades {
    private ArrayList<Integer> passingPoints;
    private ArrayList<Integer> points;
    private ArrayList<Integer> grades;
    
    public PointsAndGrades() {
        this.passingPoints = new ArrayList<>();
        this.points = new ArrayList<>();
        this.grades = new ArrayList<>();
    }
    
    public void addPoints(int point) {
        
        if (point <= 100 && point >= 0) {
            this.points.add(point);
            this.grades.add(pointsToGrade(point)); 
            if (point >= 50) {
                this.passingPoints.add(point);
            }
        }
    }
    
    public double pointAverage() {
        
        double totalPoints = 0;
        for(int point : this.points) {
            totalPoints += point;
        }
        return totalPoints / this.points.size();
    }
    
    public double pointAveragePassingGrade() {
        
        if(this.passingPoints.isEmpty()) {
            return -1;
        }
        double totalPoints = 0;
        for(int point : this.passingPoints) {
            totalPoints += point;
        }
        return 1.0*totalPoints / this.passingPoints.size();
    }
    
    public double passPercentage() {
        int participants = this.points.size();
        int passing = this.passingPoints.size();
        
        return 100.0 * passing / participants;
    }
    
    public static int pointsToGrade(int points) {

        int grade = 0;
        if (points < 50) {
            grade = 0;
        } else if (points < 60) {
            grade = 1;
        } else if (points < 70) {
            grade = 2;
        } else if (points < 80) {
            grade = 3;
        } else if (points < 90) {
            grade = 4;
        } else {
            grade = 5;
        }

        return grade;
    }
    
    public int totalGradesInPoints(int grade) {
        
        int total = 0;
        for(int recivedGrade : this.grades) {
            if (recivedGrade == grade) {
                total++;
            }
        }
        return total;
    }
}
