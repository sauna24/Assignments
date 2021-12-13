package Java2;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;

public class Historik extends Main {
    
    //titel, namn, genre, placering, land, amne, objektID, kategoriseringID, alder, ID (ISBN), kurs kommer från tabellen objekt i databas. 
    //laneDatum, returnerad och streckkod från kvittoHarKopia.
    
    String titel, namn, genre, placering, land, amne, laneDatum, returnerad, ID;
    int objektID, kategoriseringID, alder, streckkod;
    boolean kurs;
    
    public Historik(String titel, String namn, String genre, String placering, String land, String amne, String laneDatum, int objektID, int kategoriseringID, int alder, String ID, int streckkod, int kurs, String returned) {
        this.titel = titel;
        this.namn = namn;
        this.genre = genre;
        this.placering = placering;
        this.land = land;
        this.amne = amne;
        this.laneDatum = laneDatum;
        this.objektID = objektID;
        this.kategoriseringID = kategoriseringID;
        this.alder = alder;
        this.ID = ID;
        this.streckkod = streckkod;
        this.kurs = kurs == 1;
        this.returnerad = returned;
    }
    
    //SQL sats för att hämta klassens variabel.
    public static String CreateSQLQuery (int inputUser){
            
        String SQL =    "SELECT titel, namn, genre, placering, produktionsland, aldersbegransning, amnesord, laneDatum, objektID, kategoriseringID, ID, streckkod, kurslitteratur, kvitto.kvittoID, returDatum\n" +
                        "FROM kvitto\n" +
                        "JOIN (\n" +
                        "    SELECT kvittoHarKopia.kvittoID, streckkod, kvittoHarKopia.objektID, titel, namn, genre, placering, produktionsland, aldersbegransning, amnesord, kategoriseringID, ID, kurslitteratur, returDatum\n" +
                        "    FROM kvittoHarKopia\n" +
                        "    JOIN (\n" +
                        "	SELECT titel, namn, genre, placering, produktionsland, aldersbegransning, amnesord, objekt.objektID, kategoriseringID, ID, kurslitteratur\n" +
                        "       FROM objekt\n" +
                        "    ) J1 ON kvittoHarKopia.objektID = J1.objektID\n" +
                        "    WHERE returDatum IS NOT NULL\n" +
                        ") J2 ON kvitto.kvittoID = J2.kvittoID\n" +
                        "WHERE anvandarID = '" + inputUser + "';";
       
        return SQL;
    }
    
    //Tar data från ResultSet och sätter de som objekt av Historik i en ObservableList
    public static ObservableList populator (ResultSet result, ObservableList ResultList) {
        
        try {
            while (result.next()){
                Historik historik = new Historik (
                    result.getString("titel"), result.getString("namn"), result.getString("genre"), result.getString("placering"), result.getString("produktionsland"),
                    result.getString("amnesord"), result.getString("laneDatum"), result.getInt("objektID"), result.getInt("kategoriseringID"), result.getInt("aldersbegransning"),
                    result.getString("ID"), result.getInt("streckkod"), result.getInt("kurslitteratur"), result.getString("returDatum")
                );
                ResultList.add(historik);
            }
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
        return ResultList;
    }
    
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

    public String getAmne() {
        return amne;
    }

    public void setAmne(String amne) {
        this.amne = amne;
    }

    public String getLaneDatum() {
        return laneDatum;
    }

    public void setLaneDatum(String laneDatum) {
        this.laneDatum = laneDatum;
    }

    public int getObjektID() {
        return objektID;
    }

    public void setObjektID(int objektID) {
        this.objektID = objektID;
    }

    public int getKategoriseringID() {
        return kategoriseringID;
    }

    public void setKategoriseringID(int kategoriseringID) {
        this.kategoriseringID = kategoriseringID;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getStreckkod() {
        return streckkod;
    }

    public void setStreckkod(int streckkod) {
        this.streckkod = streckkod;
    }

    public boolean isKurs() {
        return kurs;
    }

    public void setKurs(boolean kurs) {
        this.kurs = kurs;
    }
    
    public String getReturnerad() {
        return returnerad;
    }

    public void setReturnerad(String returnerad) {
        this.returnerad = returnerad;
    }
    
}