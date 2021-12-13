package Java2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

// Authors Albin Dahlgren, Anton Drugge, Eric Klettenberg, Jimmy Pasehke - Grupp 2


public class Main {
    
    //All connection-information hämtas härifrån.
    private static final String CONNECTION_URL  = "jdbc:mysql://localhost:3306/bibliotekssystem";
    private static final String CONNECTION_USER = "root";
    private static final String CONNECTION_PASS = "admin";
    private static int currentUser;
    private static boolean anstalld;
    
    public static String getConnectionURL() {
        return CONNECTION_URL;
    }

    public static String getConnectionUser() {
        return CONNECTION_USER;
    }

    public static String getConnectionPass() {
        return CONNECTION_PASS;
    }
    
    public static int getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(int currentUser) {
        this.currentUser = currentUser;
    }

    public static boolean getAnstalld() {
        return anstalld;
    }
    
    public static void setAnstalld(boolean anstalld) {
        Main.anstalld = anstalld;
    }
    
    //Skapar meddelande, med input som titel och själva meddelandet.
    public static void AlertCreator(String Title, String Message){
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setContentText(Message);
        alert.setTitle(Title);
        alert.setHeaderText("");
        alert.show();
    }
    
    
    //Sökfunktionen. Tar emot parametrar och returnar en färdig TableView.
    //Columns är en array av kolumner i tabellen, attributes är en array av de motsvarande attribut som visas i kolumnen. Attributen är namnen i String form av de attribut som defineras i antigen Historik, Nuvarande, eller Objekt. 
    //Dessa två arrayer måsta matcha varandra, första elementet i Columns matchar den första elementet i attributes osv.
    //table är tabellen som ska populeras. ResultList är en tom ObservableList. SearchField är de sökfält som används i sökningen. FieldParameter är de attribut som sökfälten söker efter i tabellen objekt i databasen. Dessa två är också arrayer som måste matcha varandra.
    //searchParameter är en tom String. tableType är antigen Objekt, Historik, eller Nuvarande, beroende på vilken sökning som krävs. inputUser är vilken användare som sökning görs för. I vanligt fall är det den inloggade användaren, som hämtas genom getCurrentUser().
    
    public TableView searchFunction(TableColumn[] Columns, String[] attributes, TableView table, ObservableList ResultList, TextField[] SearchField, String[] FieldParameter, String searchParameter, String tableType, int inputUser){

        ResultList.clear();
        ResultSet result;
        
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASS);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String SQL = new String();
            
            switch (tableType) {
                case "Objekt":
                    SQL = Objekt.CreateSQLQuery (SearchField, FieldParameter, searchParameter);
                    break;
                
                case "Historik":
                    SQL = Historik.CreateSQLQuery (inputUser);
                    break;
                
                case "Nuvarande":
                    SQL = Nuvarande.CreateSQLQuery (inputUser);
                    break;
            }
            
            result = statement.executeQuery(SQL);
            
            if (!result.next()) {
                AlertCreator("Error", "Inget resultat hittad.");
            }
            
            result.beforeFirst();
            
            switch (tableType) {
                case "Objekt":
                    Objekt.populator(result, ResultList);
                    break;
                    
                case "Historik":
                    Historik.populator(result, ResultList);
                    break;
                    
                case "Nuvarande":
                    Nuvarande.populator(result, ResultList);
                    break;
            }
        }
        catch (SQLException e) {
            HandleExceptions(e);
        }

        for (int counter = 0; Columns.length > counter; counter++){
            Columns[counter].setCellValueFactory(new PropertyValueFactory<> (attributes[counter]));
            
        } 
        table.setItems(ResultList);
        
        return table;
    }

    //Bygger WHERE parameter i SQL sats beroende på hur många attribut man vill söka efter.
    public static String SQLOrWhere (TextField[] SearchField, ArrayList FieldParameter, String searchParameter) {
        
        for (int counter = 0; SearchField.length > counter; counter++){
               
            if (!SearchField[counter].getText().isEmpty()) {
                
                if (searchParameter != null) {
                    
                searchParameter += "OR " + FieldParameter.get(counter);
                }
                else {
                    
                searchParameter = "WHERE " + FieldParameter.get(counter);
                } 
            }
        }
        return searchParameter;
    }
    
    
    //Ser till att kolumner i en TableView går att redigera.
    public void editableFields (TableColumn[] Columns){
        
        for (int counter = 0; Columns.length > counter ; counter++){
            Columns[counter].setCellFactory(TextFieldTableCell.forTableColumn());
        }
    }
    
    //Går till inloggad.
    public void goBack(MouseEvent event) { //metod för att gå tillbaka
        try {
            App.setRoot("inloggad");
        }
        catch (IOException e) {
            HandleExceptions(e);
        }
    }
    
    //Loggar ut.
    public void logOut(MouseEvent event) { //metod för att logga ut
        try {
            App.setRoot("utloggad");
            AlertCreator("Utloggad.", "Välkommen åter.");
            setAnstalld(false);
        }
        catch (IOException e) {
            HandleExceptions(e);
        }
    }
    
    
    // Verktyg för att hantera alla exceptions samtidigt ifall ett fel upstår.
    public static void HandleExceptions (Exception e) {
//        e.printStackTrace();
    }
    
}