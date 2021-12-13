/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jimmy
 */
public class Ex2test {

static boolean inloggad = false; // Skapar lite globala variabler som behövs
static String user;
static ArrayList<String> spinnBok= new ArrayList<String>();
static ArrayList<String> aeroBok= new ArrayList<String>();
static ArrayList<String> yogaBok= new ArrayList<String>();
    
static boolean checkLuhn(String cardNo) //lånad metod
{ 
    int nDigits = cardNo.length(); 
  
    int nSum = 0; 
    boolean isSecond = false; 
    for (int i = nDigits - 1; i >= 0; i--)  
    { 
  
        int d = cardNo.charAt(i) - '0'; 
  
        if (isSecond == true) 
            d = d * 2; 
  
        // We add two digits to handle 
        // cases that make two digits  
        // after doubling 
        nSum += d / 10; 
        nSum += d % 10; 
  
        isSecond = !isSecond; 
    } 
    return (nSum % 10 == 0); 
} 
  
    // Driver code 
    static public void main (String[] args) 
    { 
        showMenu();
    } 
    
    public static void showMenu(){ // metod för menyn
        Scanner input = new Scanner(System.in);
        System.out.println("\n 1. Bli medlem \n 2. Logga in \n 3. Boka plats på aktivitet \n 4. Avsluta ");   
        while (true){
            int selectMenu = input.nextInt();
            switch (selectMenu) {
                case 1:{ // skickar en vidare till metoden för att registrera användare
                    signUp();
                }
                case 2:{ // skickar en vidare till metoden för att logga in
                    logIn();
                }
                case 3:{ // skickar en vidare till metoden för att boka aktivitet
                    if(inloggad == true){
                        activityBooking();}
                    else{
                        System.out.println("Du måste vara inloggad");
                        showMenu();
                    }
                }
                case 4:{ //stänger programmet
                System.exit(0);
                }
            }
        }
    
    }
    
    public static void signUp(){
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in personnummer: ");
        String cardNo = input.nextLine();
        user = cardNo;

        if (checkLuhn(cardNo)) { // kollar så att personnummret är giltligt och skickar sedan vidare en för inmatning av antal månader
            inloggad = true;
            monthlyFee();
        }
        else{
            System.out.println("Felaktigt personnummer"); 
            showMenu();
        }
    }
    
    public static void monthlyFee(){ // räknar ut totala kostnaden
        int pris;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in antalet månader du vill köpa: ");
        int numMonths = input.nextInt();
        
        if(numMonths <= 2){ // räknar ut priset beroende på antalet månader
            pris = numMonths * 400;
            pris += 100;
        }
        else if(numMonths <= 6){
            pris = numMonths * 350;
            pris += 100;            
        }
        else if(numMonths <= 12){
            pris = numMonths * 300;
            pris += 100;        
        }
        else{
            pris = numMonths * 250;
            pris += 100;        
        }
        System.out.println("Totala priset: " + pris);
        showMenu(); // skickar tillbacka en till menyn
    }
    
    public static void activityBooking(){ // använda för att boka aktiviteter
        


        
        Scanner input = new Scanner(System.in);
        System.out.println("Välj typ av aktivitet \n 1. Spinning \n 2. Aerobics \n 3. Yoga ");   
        
        while (true){
            int selectMenu = input.nextInt();
            switch (selectMenu) { // skickar vidare en till relevant metod beroende på val av aktivitet
                case 1:{
                    spinning();

                }
                case 2:{
                    yoga();

                }
                case 3:{
                    aero();
                    
                }
                default:{
                System.out.println("Ogiltligt menyval"); 
                break;
                }
            }
        }
    }
    public static void logIn(){ // metoden för inloggning, är extremt simpel och hade kunnat utvecklats mer
        Scanner input = new Scanner(System.in);
        System.out.println("Ange personNR");   
        String tmp = input.nextLine();
        
        if(user.equals(tmp)){ // kollar så personnummret stämmer med det som finns i systemet
            inloggad = true;
            System.out.println("Du är nu inloggad");
            showMenu();
        }else{
            System.out.println("Fel personnummer");
            showMenu();
    }
    }
    public static void spinning(){ // metod för bokningen av spinning

        Scanner input = new Scanner(System.in);
        System.out.println("Ange plats i salen enligt (rad 1-3, plats a,b,c");   
        String spinning = input.nextLine();

        if(spinnBok.contains(spinning)){
            System.out.println("Platsen är redan bokad");
            activityBooking();
            }
            else{
            System.out.println("Du har nu bokat platsen");
            spinnBok.add(spinning);
            showMenu();
            }
    
    }
    public static void yoga(){// metod för bokningen av yoga
        Scanner input = new Scanner(System.in);
        System.out.println("Ange plats i salen enligt (rad 1-3, plats a,b,c");   
        String yoga = input.nextLine();

        if(yogaBok.contains(yoga)){
            System.out.println("Platsen är redan bokad");
            activityBooking();
            }
            else{
            System.out.println("Du har nu bokat platsen");
            yogaBok.add(yoga);
            showMenu();
            }
    }
    public static void aero(){// metod för bokningen av aero
        Scanner input = new Scanner(System.in);
        System.out.println("Ange plats i salen enligt (rad 1-3, plats a,b,c");   
        String aero = input.nextLine();

        if(aeroBok.contains(aero)){
            System.out.println("Platsen är redan bokad");
            activityBooking();
            }
            else{
            System.out.println("Du har nu bokat platsen");
            spinnBok.add(aero);
            showMenu();
            }
    }
} 
