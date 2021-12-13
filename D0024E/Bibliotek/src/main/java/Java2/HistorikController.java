package Java2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HistorikController extends Main implements Initializable {

    @FXML
    private TableView<?> table;
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
    private TableColumn<?, ?> ColumnReturned;
    
    private final ObservableList<Objekt> ResultList = FXCollections.observableArrayList();

    
    //Gör historiksökning när vyn öppnas och sätter data i tabell. Detaljerad beskrivning finns i klassen Main.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String searchParameter = null;
        String tableVariant = "Historik";

        TextField[] SearchField = null;
        String[] FieldAttribute = null;

        TableColumn[] Columns = {KolumnDatum, KolumnGenre, KolumnProduktionsland, KolumnTitel, KolumnFörfattare, ColumnReturned};
        String[] ColumnAttribute = {"laneDatum", "genre", "land", "titel", "namn", "returnerad"};

        table = searchFunction(Columns, ColumnAttribute, table, ResultList, SearchField, FieldAttribute, searchParameter, tableVariant, getCurrentUser());
    }
    
    @FXML
    void BackClicked(MouseEvent event) {
        try {
            App.setRoot("MinaSidor");
        }
        catch (IOException e) {
            HandleExceptions(e);
        }
    }

    @FXML
    void LogOutClicked(MouseEvent event) {
        logOut(event);
    }

}