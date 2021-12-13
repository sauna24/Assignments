package Java2;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;

public class Nuvarande extends Main {
    
    //titel, namn, genre, placering, land, amne, objektID, kategoriseringID, alder, ID (ISBN), kurs kommer från tabellen objekt i databas. 
    //laneDatum och streckkod från kvittoHarKopia. maxRetur beräknas från laneDatum och maxLaneTid i tabellen objektkategorisering.
    
    String titel, namn, genre, placering, land, amne, laneDatum, maxRetur, ID;
    int objektID, kategoriseringID, alder, streckkod;
    boolean kurs;

    public Nuvarande(String titel, String namn, String genre, String placering, String land, String amne, String laneDatum, int objektID, int kategoriseringID, int alder, String ID, int streckkod, int kurs, String maxRetur) {
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
        this.maxRetur = maxRetur;
    }
    
    //SQL sats för att hämta klassens variabel.
    public static String CreateSQLQuery (int inputUser){
            
        String SQL =    "SELECT titel, namn, genre, placering, produktionsland, aldersbegransning, amnesord, laneDatum, objektID, kategoriseringID, ID, streckkod, kurslitteratur, kvitto.kvittoID, DATE_ADD(laneDatum, INTERVAL maxLaneTid DAY) AS maxRetur\n" +
                        "FROM kvitto\n" +
                        "JOIN (\n" +
                        "    SELECT kvittoHarKopia.kvittoID, streckkod, kvittoHarKopia.objektID, titel, namn, genre, placering, produktionsland, aldersbegransning, amnesord, kategoriseringID, ID, kurslitteratur, maxLaneTid\n" +
                        "    FROM kvittoHarKopia\n" +
                        "    JOIN (\n" +
                        "	 SELECT titel, namn, genre, placering, produktionsland, aldersbegransning, amnesord, objekt.objektID, objekt.kategoriseringID, ID, kurslitteratur, maxLaneTid\n" +
                        "        FROM objekt\n" +
                        "        JOIN(\n" +
                        "           SELECT kategoriseringID, maxLaneTid\n" +
                        "           FROM objektkategorisering\n" +
                        "        ) J3 ON J3.kategoriseringID = objekt.kategoriseringID\n" +
                        "    ) J1 ON kvittoHarKopia.objektID = J1.objektID\n" +
                        "    WHERE returDatum IS NULL\n" +
                        ") J2 ON kvitto.kvittoID = J2.kvittoID\n" +
                        "WHERE anvandarID = " + inputUser + ";";
       
        return SQL;
    }
    //Tar data från ResultSet och sätter de som objekt av Nuvarande i en ObservableList
    public static ObservableList populator (ResultSet result, ObservableList ResultList) {
        
        try {
            while (result.next()){
                Nuvarande nuvarande = new Nuvarande (
                    result.getString("titel"), result.getString("namn"), result.getString("genre"), result.getString("placering"), result.getString("produktionsland"),
                    result.getString("amnesord"), result.getString("laneDatum"), result.getInt("objektID"),  result.getInt("kategoriseringID"), result.getInt("aldersbegransning"),
                    result.getString("ID"), result.getInt("streckkod"), result.getInt("kurslitteratur"), result.getString("maxRetur")
                );
                ResultList.add(nuvarande);
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
    
    public String getMaxRetur() {
        return maxRetur;
    }

    public void setMaxRetur(String maxRetur) {
        this.maxRetur = maxRetur;
    }
    
}