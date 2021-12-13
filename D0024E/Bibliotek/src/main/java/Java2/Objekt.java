package Java2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class Objekt extends Main {
    
    String titel, namn, genre, placering, land, amne, kategori, alder, ISBN, kurs;
    int objektID, tillganglighet;
    
    public Objekt(String titel, String namn, String genre, String placering, int kategorisering, String land, String alder, String amne, int objektID, String ISBN, int tillganglighet, int NewKurs) {
        this.titel = titel;
        this.namn = namn;
        this.genre = genre;
        this.placering = placering;
        this.land = land;
        this.alder = alder;
        this.amne = amne;
        this.objektID = objektID;
        this.ISBN = ISBN;
        this.tillganglighet = tillganglighet;
        
        switch (NewKurs) {
            case 1:
                this.kurs = "Ja";
                break;
                
            case 0:
                this.kurs = "Nej";
                break;
        }
        
        switch (kategorisering) {
            case 1:
                this.kategori = "Bok";
                break;
                
            case 2:
                this.kategori = "Film";
                break;
                
            case 3:
                this.kategori = "Tidning";
                break;
                
            case 4:
                this.kategori = "Tidsskrift";
                break;
        }
    }

    //Skapar SQL sats för att fylla klassens attribut.
    public static String CreateSQLQuery (TextField[] SearchField, String[] FieldAttribute, String searchParameter){
            
        ArrayList FieldParameter = new ArrayList();
        
        String control = null;
        
        for (int counter = 0; counter < FieldAttribute.length; counter++) {
                
            String parameter = FieldAttribute[counter] + " LIKE '%" + SearchField[counter].getText() + "%'\n";
            
            control += SearchField[counter].getText();
            
            FieldParameter.add(parameter);
        }
            
        String SQL = new String();  
        
        //Tillåter tom sökning.
        if (control.equals("null")) {
            
            SQL =   "SELECT objekt.objektID, namn, titel, genre, placering, kategoriseringID, produktionsland, aldersbegransning, ID, amnesord, kurslitteratur, COALESCE(SUM(paPlats), 0) tillganglighet\n" +
                    "FROM objekt\n" +
                    "LEFT JOIN (\n" +
                    "   SELECT kopia.objektID, paPlats\n" +
                    "   FROM kopia\n" +
                    ") J ON objekt.objektID = J.objektID\n" +
                    "GROUP BY objektID\n" +
                    "LIMIT 100";
        }
        else {
            SQL =   "SELECT objekt.objektID, namn, titel, genre, placering, kategoriseringID, produktionsland, aldersbegransning, ID, amnesord, kurslitteratur, COALESCE(SUM(paPlats), 0) tillganglighet\n" +
                    "FROM objekt \n" +
                    "LEFT JOIN (\n" +
                    "   SELECT kopia.objektID, paPlats\n" +
                    "   FROM kopia \n" +
                    ") J ON objekt.objektID = J.objektID\n" +
                    Main.SQLOrWhere(SearchField, FieldParameter, searchParameter) +
                    "GROUP BY objektID\n" +
                    "LIMIT 100";
        }
        return SQL;
    }

    //Lägger till post i Objekt. Inputparametrar är postens attribut.
    public static void AddPost (String NewTitel, String NewNamn, String NewGenre, String NewAmne, String NewPlacering, String NewID, String NewLand, String NewAlder, String NewKategori, String NewKurs){
        
        String SQL =    "INSERT INTO objekt (titel, namn, genre, amnesord, placering, ID, produktionsland, aldersbegransning, kategoriseringID, kurslitteratur)\n" +
                        "VALUES ('" + NewTitel + "', '" + NewNamn + "', '" + NewGenre + "', '" + NewAmne + "', '" + NewPlacering + "', '" + NewID + "', '" + NewLand + "', '" + NewAlder + "', '" + NewKategori + "', '" + NewKurs + "')";
        
        try {
            Connection connection = DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);  
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }
    
    //Raderar post i Objekt beroende på vilken PK som ges.
    public static void DeletePost (int PrimaryKey) {
        String SQL = "DELETE FROM objekt WHERE objektID = '" + PrimaryKey + "'";
        
        try {
            Connection connection = DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL); 
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }
    
    
    //Följande är metoder för att uppdatera attribut i tabellen Objekt i databasen. Inputparameter som PK och det nya attributvärdet.
    public static void DBUpdateTitel(int PK, String NewTitle) {
        String SQL =    "UPDATE objekt \n"+
                        "SET titel = '" + NewTitle + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);  
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }
    
    public static void DBUpdateNamn(int PK, String NewNamn) {
        String SQL =    "UPDATE objekt \n"+
                        "SET namn = '" + NewNamn + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }    
    
    public static void DBUpdateGenre(int PK, String NewGenre) {
        String SQL =    "UPDATE objekt \n"+
                        "SET genre = '" + NewGenre + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);  
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }    

    public static void DBUpdatePlacering(int PK, String NewPlacering) {
        String SQL =    "UPDATE objekt \n"+
                        "SET placering = '" + NewPlacering + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }

    public static void DBUpdateLand(int PK, String NewLand) {
        String SQL =    "UPDATE objekt \n"+
                        "SET produktionsland = '" + NewLand + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }

    public static void DBUpdateAmne(int PK, String NewAmne) {
        String SQL =    "UPDATE objekt \n"+
                        "SET amnesord = '" + NewAmne + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }

    public static void DBUpdateKategori(int PK, String NewKategori) {
        String SQL =    "UPDATE objekt \n"+
                        "SET kategoriseringID = '" + NewKategori + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }    

    public static void DBUpdateAlder(int PK, String NewAlder) {
        String SQL =    "UPDATE objekt \n"+
                        "SET aldersbegransning = '" + NewAlder + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }

    public static void DBUpdateISBN(int PK, String NewISBN) {
        String SQL =    "UPDATE objekt \n"+
                        "SET ID = '" + NewISBN + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }

    public static void DBUpdateKurs(int PK, String NewKurs) {
        String SQL =    "UPDATE objekt \n"+
                        "SET kurslitteratur = '" + NewKurs + "'\n"+
                        "WHERE objektID = '" + PK + "';\n";
        
        try {
            Connection connection = DriverManager.getConnection(Main.getConnectionURL(), Main.getConnectionUser(), Main.getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(SQL);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }   
    
    //Tar data från ResultSet och sätter de som objekt av Objekt i en ObservableList
    public static ObservableList populator (ResultSet result, ObservableList ResultList) {
        
        try {
            while (result.next()){
                Objekt objekt = new Objekt (
                    result.getString("titel"), result.getString("namn"), result.getString("genre"), result.getString("placering"), result.getInt("kategoriseringID"),
                    result.getString("produktionsland"), result.getString("aldersbegransning"), result.getString("amnesord"), result.getInt("objektID"), result.getString("ID"),
                    result.getInt("tillganglighet"), result.getInt("kurslitteratur") 
                );
            ResultList.add(objekt);
            }
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
        return ResultList;
    }
    
//    Getters och setters på attributen inom objekt.
    
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlacering() {
        return placering;
    }

    public void setPlacering(String placering) {
        this.placering = placering;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getAlder() {
        return alder;
    }

    public void setAlder(String alder) {
        this.alder = alder;
    }

    public String getAmne() {
        return amne;
    }

    public void setAmne(String amne) {
        this.amne = amne;
    }

    public int getObjektID() {
        return objektID;
    }

    public void setObjektID(int objektID) {
        this.objektID = objektID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getTillganglighet() {
        return tillganglighet;
    }

    public void setTillganglighet(int tillganglighet) {
        this.tillganglighet = tillganglighet;
    }

    public String isKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }
    
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
}