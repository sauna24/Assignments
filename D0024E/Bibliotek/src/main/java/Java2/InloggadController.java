package Java2; 

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class InloggadController extends Main implements Initializable{

    @FXML
    private TableView<Objekt> table;
    @FXML
    private TableColumn<Objekt, String> ColumnTitel;
    @FXML
    private TableColumn<Objekt, String> ColumnGenre;
    @FXML
    private TableColumn<Objekt, String> ColumnNamn;
    @FXML
    private TableColumn<Objekt, String> ColumnAmne;
    @FXML
    private TableColumn<Objekt, String> ColumnTillganglig;
    @FXML
    private TableColumn<Objekt, String> ColumnPlats;
    @FXML
    private TableColumn<Objekt, String> ColumnKurs;
    @FXML
    private TableColumn<Objekt, String> ColumnID;
    @FXML
    private TextField Titel;
    @FXML
    private TextField Namn;
    @FXML
    private TextField Genre;
    @FXML
    private TextField ID;
    @FXML
    private TextField Amne;
    
    private final ObservableList<Objekt> ResultList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    //Gör objektsökning när knappen klickas och sätter datan i en tabell. Detaljerad beskrivning av searchFunction finns i klassen Main.
    @FXML
    private void TrySearch(MouseEvent event) {
        
        String searchParameter = null;
        String tableVariant = "Objekt";
        
        TextField[] SearchField     = {ID,              Titel,              Namn,               Genre,              Amne                };
        String[] FieldAttribute     = {"ID",            "titel",            "namn",             "genre",            "amnesord"          };
        
        TableColumn[] Columns       = {ColumnTitel,     ColumnGenre,        ColumnNamn,         ColumnAmne,         ColumnTillganglig,      ColumnPlats,        ColumnKurs,         ColumnID    };
        String[] ColumnAttribute    = {"titel",         "genre",            "namn",             "amne",             "tillganglighet",       "placering",        "kurs",             "ISBN"      };
        
        table = searchFunction(Columns, ColumnAttribute, table, ResultList, SearchField, FieldAttribute, searchParameter, tableVariant, getCurrentUser());
    }

    
    //Går till mina sidor.
    @FXML
    private void TryMinaSidor(MouseEvent event) {
        try {
            App.setRoot("MinaSidor");
        } 
        catch (IOException e) {
            HandleExceptions(e);
        }
    }

    
    //Går till utloggad.
    @FXML
    private void TryLoggaUt(MouseEvent event) {
        logOut(event);
    }

    
    //Metod för att låna en kopia.
    @FXML
    private void TryLoan(MouseEvent event) { 
        
        Objekt objekt = table.getSelectionModel().getSelectedItem(); 
        
        if (objekt == null) {
            AlertCreator ("Felmeddelande", "Välj ett objekt");
        }
        
        int tillganglighet = objekt.getTillganglighet();
        int id = objekt.getObjektID();
        
        LocalDate laneDatum =  LocalDate.now();
        int anvandarID = getCurrentUser(); 
        
        Random random = new Random(); 
        int kvittoID = random.nextInt(1000000); //AUTO_INCREMENT i databas inte en ideal lösning, då PK krävs för framtida sökningar.
        
        String SQLselectStreckkod = "SELECT streckkod FROM kopia\n" 
                                    +"WHERE paPlats ='1' AND objektID = '" + id + "'\n"
                                    +"LIMIT 1;"; //första streckkoden som är tillgänglig
        
        try {
            Connection connection = DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPass());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQLselectStreckkod);
        
            rs.next();
            String streckkod = rs.getString("streckkod");
             
            String SQL =                "UPDATE bibliotekssystem. kopia\n"
                                        + "SET paPlats = 0\n" 
                                        + "WHERE objektID = " + id + " AND streckkod = " + streckkod;  
        
            String SQLinsertKvitto =    "INSERT INTO kvitto (kvittoID, laneDatum, anvandarID) VALUES ('" + kvittoID + "','" + laneDatum + "','" + anvandarID + "')";
            String SQLkvittohk =        "INSERT INTO kvittoharkopia (kvittoID, streckkod, objektID) VALUES ('" + kvittoID + "','" + streckkod + "','" + id + "')"  ;
        
            //Kontroll som ser till att man inte överskrider max antal lån.
            String SQLMaxLanControl =   "SELECT maxAntalLan, antalLan\n" +
                                        "FROM kategoriseringanv \n" +
                                        "JOIN (\n" +
                                        "   SELECT kategoriseringAnvID, antalLan\n" +
                                        "   FROM anvandare \n" +
                                        "   WHERE anvandarID = '" + getCurrentUser() + "'\n" +
                                        ") J ON J.kategoriseringAnvID = kategoriseringanv.kategoriseringAnvID";
        
            ResultSet result = statement.executeQuery(SQLMaxLanControl);
            result.next();
            int MaxLan = result.getInt("maxAntalLan");
            int CurrentLan = result.getInt("antalLan");

            if (tillganglighet < 1 || MaxLan <= CurrentLan) {
                AlertCreator("Error", "Ej tillgänglig");
            }
            else {
                statement.executeUpdate(SQLinsertKvitto);
                statement.executeUpdate(SQLkvittohk);
                statement.executeUpdate(SQL);
                
                //Bygger kvitto
                rs = statement.executeQuery("SELECT maxLaneTid FROM objektkategorisering JOIN (SELECT objektID, kategoriseringID FROM objekt) J ON J.kategoriseringID = objektkategorisering.kategoriseringID WHERE J.objektID = " + id);
                rs.next();
                String kvitto = "Du har lånat: " + objekt.getTitel() + "\nID: " + objekt.getISBN() + "\nStreckkod: " + streckkod + "\nSenaste returdatum: " + laneDatum.plusDays(rs.getInt("maxLaneTid"));
                
                AlertCreator("Kvitto", kvitto);
            } 
        }
        catch (SQLException e) {
            HandleExceptions(e);
        }
    }

}
