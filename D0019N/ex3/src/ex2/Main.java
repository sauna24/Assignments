/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.Scanner;

/**
 *
 * @author jimmy Pasehke
 */
public class Main {
    
        Scanner in = new Scanner(System.in);
        int PlayerHP, PlayerDMG;
        String PlayerName, choice;
        boolean sword, key, potion, dragonStatus = false;
        int monsterHP = 8;
        
    public static void main(String[] args){
        Main NyttSpel;
        NyttSpel = new Main();
        
        NyttSpel.PlayerCharacter();
        NyttSpel.GameStart();
        
       
    }
    public void PlayerCharacter(){ // sätter baseline stats för spelaren
        PlayerHP = 10;
        PlayerDMG = 1;
        System.out.println("Write your name and press ENTER");
        PlayerName = in.nextLine();
        
    }
    public void GameStart(){   // här börjar koden
        System.out.println("Welcome " + PlayerName + " to your treasure hunt. Beware of the dragon \n" + 
                "You are standing outside a cave. There is a smell of sulfur coming from the opening\n" +
                "The cave opening is to your east. Write \"e\" and press [Enter] to enter the cave");
        choice = in.nextLine();
        if (choice.equals("e")){
            System.out.println("As you enter the cave the entrance collapses behind you."); // Har denna här så att den inte spammar om man går fram och tbx
            Room1(); //skickar en vidare till rum1
            
        }
    }
    public void Room1(){//första rummet man kommer till
        System.out.println("The room is lit by a few candles sitting on a table in front of you.\n" +
                           "You can go north [n] and south [s]");
        choice = in.nextLine();
        if (choice.equals("n")){ //skickar vidare en till rummet man väljer
            Room2();
        }else if (choice.equals("s")){
            Room3();
        }else {
            System.out.println("The path is blocked, try a differet way");
        }
    }
    public void Room2(){ //Rummet med svärdet
        
        if (sword == false){ 
            System.out.println("You see a sword next to a dead body on the floor.\n"+
                             "You can pick up the sword [p], and go [s] or [e]");
        }else if (sword == true){//detta är för att byta meddelande om man redan har svårdet men går tbx
            System.out.println("You see a dead body on the floor, this is where you found your sword. \n"+
                             "You can go [s] or [e]");           
        }
        choice = in.nextLine();
        if (choice.equals("p")){
            this.PlayerDMG = 2; // buffar ens skada bär man har svärdet
            sword = true; // anger att man har svärdet
            System.out.println("You picked up the sword. You see a dead body on the floor. You can go [s] and [e]");
            Room2();
       }
        if(choice.equals("s")){ 
             Room1();
        }else if(choice.equals("e")){
             Room4();
            }
           
    }
    public void Room3(){// rummet med nyckeln
        if (key == false){
            System.out.println("You see a key laying on the floor.\n" +
                               "You can pick up the key [p], and go [n] or [e]");
        }else {
            System.out.println("You can go [n] or [e]");
        }
        choice = in.nextLine();
        if (choice.equals("p")){
            key = true;  // "ger" spelaren nyckeln
            System.out.println("You picked up the key. You see an empty room. You can go [n] and [e]");
            Room3();
        }
            if (choice.equals("n")){
                 Room1();
            }else if(choice.equals("e")){
                 Room5();
            }
        
        

    }
    public void Room4(){ //rummet med ett monster i
        
        while(monsterHP > 0){ // fighten mot första monstret
            System.out.println("A beast attacks you and does 1 damage\n"+"You attack the beast and do " + PlayerDMG +" damage");
            this.PlayerHP--;
            monsterHP = monsterHP - PlayerDMG;
        }
        System.out.println("You defeat the beast, but you only have " + PlayerHP +" hitpoints left. Will it be enough for a fight with a dragon?");
        System.out.println("You see an exit to the east [e], a room to the west [w] and a room to the south [s]");
        choice = in.nextLine();
        if(choice.equals("e")){
            RoomExit();
        }else if(choice.equals("w")){
            Room2();
        }else if(choice.equals("s")){
            Room5();
        }
    }
    public void Room5(){// rummet innan draken med hp potion
        if (key == false){// olika meddelanden beroende på om man har nyckeln eller inte
        System.out.println("You see a locked door to the east, a way to the north [n], and a way to the west [w]\n" + 
                            "You see a health potion on the floor, you can pick it up [p]");
        }else {
        System.out.println("The door to the east [e] can now be unlocked, you also see a way to the north [n], and a way to the west\n" + "[w] " + 
                            "You see a health potion on the floor, you can pick it up [p]");            
        }
        choice = in.nextLine();
        if(choice.equals("n")){
            Room4();
        }else if(key==true && choice.equals("e")){ //kollar så man han nyckeln om man vill gå till draken
            Room6();
        }else if(choice.equals("w")){
            Room3();
        }else if(choice.equals("p")){
            System.out.println("You pick up the potion\n" + 
                               "You only have 6 hitpoints left. Might be a good idea to drink that health potion [d]");
            potion = true;
            Room5();
        }else if(choice.equals("d") && potion == true){
            PlayerHP = 10; // healar spelaren till fullt
            potion = false;
            System.out.println("You drink the health potion and are now at full health");
            Room5();
        }
        
    } 

    public void Room6(){
        
        int dragonHP = 18; // sätter drakens hp för den kommande fighten
        
        System.out.println(
            " .~))>>\n"+
            " .~)>>\n"+
            " .~))))>>>\n"+
            " .~))>> ___\n"+
            " .~))>>)))>> .-~))>>\n"+
            " .~)))))>> .-~))>>)>\n"+
            " .~)))>>))))>> .-~)>>)>\n"+
            " ) .~))>>))))>> .-~)))))>>)>\n"+
            " ( )@@*) //)>)))))) .-~))))>>)>\n"+
            " ).@(@@ //))>>))) .-~))>>)))))>>)>\n"+
            " (( @.@). //))))) .-~)>>)))))>>)>\n"+
            " )) )@@*.@@ ) //)>))) //))))))>>))))>>)>\n"+
            " (( ((@@@.@@ |/))))) //)))))>>)))>>)>\n"+
            " )) @@*. )@@ ) (\\_(\\-\\b |))>)) //)))>>)))))))>>)>\n"+
            " (( @@@(.@(@ . _/`-` ~|b |>))) //)>>)))))))>>)>\n"+
            " )* @@@ )@* (@) (@) /\\b|))) //))))))>>))))>>\n"+
            " (( @. )@( @ . _/ / / \\b)) //))>>)))))>>>_._\n"+
            " )@@ (@@*)@@. (6///6)- / ^ \\b)//))))))>>)))>> ~~-.\n"+
            " ( @jgs@@. @@@.*@_ VvvvvV// ^ \\b/)>>))))>> _. `bb\n"+
            " ((@@ @@@*.(@@ . - | o |' \\ ( ^ \\b)))>> .' b`,\n"+
            " ((@@).*@@ )@ ) \\^^^/ (( ^ ~)_ \\ / b `,\n"+
            " (@@. (@@ ). `-' ((( ^ `\\ \\ \\ \\ \\| b `.\n"+
            " (*.@* / (((( \\| | | \\ . b `.\n"+
            " / / ((((( \\ \\ / _.-~\\ Y, b ;\n"+
            " / / / (((((( \\ \\.-~ _.`\" _.-~`, b ;\n"+
            " / / `(((((() ) (((((~ `, b ;\n"+
            " _/ _/ `\"\"\"/ /' ; b ;\n"+
            " _.-~_.-~ / /' _.'~bb _.'\n"+
            " ((((~~ / /' _.'~bb.--~\n"+
            " (((( __.-~bb.-~\n"+
            " .' b .~~\n"+
            " :bb ,' \n"+
            " ~~~~\n"+
            "An angry dragon appears\n"
            
        );
        while(dragonHP > 0 && PlayerHP <= 1 ){ // fighten med draken, kollar så att spelaren inte dör
            System.out.println("A dragon attacks you and does 1 damage\n"+"You attack the dragon and do " + PlayerDMG +" damage");
            this.PlayerHP--;
            dragonHP = dragonHP - PlayerDMG;
        }
        if(PlayerHP > 0){// om spelaren dör printas ett game over meddelande
            System.out.println("Game over, the dragon killed you try healing before the fight");
            System.exit(0);
        }
        System.out.println("You defeat the dragon and collect the treasure. Can you escape this dungeon with all your riches?\n" +
                           "You drag the gold out the way you came from");
        dragonStatus = true;
        Room5();
    }
    public void RoomExit(){
        if(dragonStatus == false){//kollar om draken är död
            System.out.println("The dragon is not dead.");
            Room4();
        }else if(dragonStatus == true){
            System.out.println(
                " _.--.\n"+
                " _.-'_:-'||\n"+
                " _.-'_.-::::'||\n"+
                " _.-:'_.-::::::' ||\n"+
                " .'`-.-:::::::' ||\n"+
                " /.'`;|:::::::' ||_\n"+
                " || ||::::::' _.;._'-._\n"+
                " || ||:::::' _.-!oo @.!-._'-.\n"+
                " \'. ||:::::.-!()oo @!()@.-'_.|\n"+
                " '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
                " `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
                " ||-._'-.@.-'_.-' _.-o |'||\n"+
                " ||=[ '-._.-\\U/.-' o |'||\n"+
                " || '-.]=|| |'| o |'||\n"+
                " || || |'| _| ';\n"+
                " || || |'| _.-'_.-'\n"+
                " |'-._ || |'|_.-'_.-'\n"+
                " '-._'-.|| |' `_.-'\n"+
                " '-.||_/.-'\n" +
                "You leave the dungeon with your riches. Congratulations, you won"
            );
           System.exit(0);
        }
        
    }
}
