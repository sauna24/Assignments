package Java2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MinaSidorController extends Main implements Initializable {

    @FXML
    private TableColumn<?, ?> KolumnDatum;
    @FXML
    private TableColumn<?, ?> KolumnGenre;
    @FXML
    private TableColumn<?, ?> KolumnProduktionsland;
    @FXML
    private TableColumn<?, ?> KolumnTitel;
    @FXML
    private TableColumn<?, ?> KolumnFörfattare;
    @FXML
    private TableColumn<?, ?> ColumnMaxRetur;
    @FXML
    private TableView<Nuvarande> table;
    @FXML
    private Button RedigeraObjekt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Sätter knappen för att redigera objekt synlig om man är anställd.
        if (getAnstalld() == true) {
            RedigeraObjekt.setVisible(true);
            RedigeraObjekt.setManaged(true);
        }
    }
    
    //Avslutar ett lån, genom att stoppa in värde för returdatum i tabellen KvittoHarKopia i databas.
    @FXML
    private void LämnatillbakaClicked(MouseEvent event) {
        Nuvarande objekt = table.getSelectionModel().getSelectedItem();  
        int streckkod = objekt.getStreckkod();
        LocalDate curDate =  LocalDate.now();
        
        try {
            Connection connection = DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPass());
            Statement statement = connection.createStatement();

                String SQLupdate =  "UPDATE kvittoharkopia \n"
                                    + "SET returdatum = '" + curDate + "'\n"
                                    + "WHERE streckkod = " + streckkod;

            statement.executeUpdate(SQLupdate);
        } 
        catch (SQLException e) {
            HandleExceptions(e);
        }
        AlertCreator("Bok återlämnad.", "Bok återlämnad.");
    }

    //Går tillbaka.
    @FXML
    private void BackClicked(MouseEvent event) { //2021/05/14
        goBack(event);  
    }

    //Loggar ut.
    @FXML
    private void LogOutClicked(MouseEvent event) { //2021/05/14
        logOut(event);
    }

    
    private final ObservableList<Objekt> ResultList = FXCollections.observableArrayList();

    
    //Gör sökning i Nuvarande och fyller tabell med data. Detaljerad beskrivning för searchFuntion finns i Main.
    @FXML
    void ShowLåneHistorikClicked(MouseEvent event) {

        String searchParameter = null;
        String tableVariant = "Nuvarande";

        TextField[] SearchField = null;
        String[] FieldAttribute = null;

        TableColumn[] Columns = {KolumnDatum, KolumnGenre, KolumnProduktionsland, KolumnTitel, KolumnFörfattare, ColumnMaxRetur};
        String[] ColumnAttribute = {"laneDatum", "genre", "land", "titel", "namn", "maxRetur"};

        table = searchFunction(Columns, ColumnAttribute, table, ResultList, SearchField, FieldAttribute, searchParameter, tableVariant, getCurrentUser());
    }

    //Går till objektredigering.
    @FXML
    private void EditObjektClicked(MouseEvent event) {
        try {
            App.setRoot("redigeraObjekt");
            
        } catch (IOException e) {
            HandleExceptions(e);
        }
    }

    //Går till lånehistorik.
    @FXML
    private void ShowAvgifterClicked(MouseEvent event) {
        try {
            App.setRoot("historik");
            
        } catch (IOException e) {
            HandleExceptions(e);
        }
    }
    
}
