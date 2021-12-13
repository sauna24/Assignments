package Java2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.input.MouseEvent;

public class RedigeraObjektController extends Main implements Initializable {

    @FXML
    private TableView<Objekt> table;
    @FXML
    private TableColumn<Objekt, String> ColumnTitel;
    @FXML
    private TableColumn<Objekt, String> ColumnNamn;
    @FXML
    private TableColumn<Objekt, String> ColumnGenre;
    @FXML
    private TableColumn<Objekt, String> ColumnAmne;
    @FXML
    private TableColumn<Objekt, String> ColumnKurs;
    @FXML
    private TableColumn<Objekt, String> ColumnPlats;
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
    @FXML
    private TableColumn<Objekt, String> ColumnLand;
    @FXML
    private TableColumn<Objekt, String> ColumnAlder;
    @FXML
    private TableColumn<Objekt, String> ColumnKategori;
    @FXML
    private TextField AddNamn;
    @FXML
    private TextField AddGenre;
    @FXML
    private TextField AddAmne;
    @FXML
    private TextField AddPlacering;
    @FXML
    private TextField AddID;
    @FXML
    private TextField AddLand;
    @FXML
    private TextField AddAlder;
    @FXML
    private ComboBox<String> AddKurs;
    @FXML
    private ComboBox<String> AddKategori;
    @FXML
    private TextField AddTitel;
    @FXML
    private TextField copies;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Ser till att kolumner går att redigera
        TableColumn[] Columns = {ColumnTitel, ColumnGenre, ColumnNamn, ColumnAmne, ColumnLand, ColumnPlats, ColumnID, ColumnAlder};
        editableFields(Columns);

        //Fyller värden på combobox.
        ColumnKategori.setCellFactory(ComboBoxTableCell.forTableColumn("Bok", "Film", "Tidning", "Tidsskrift"));
        ColumnKurs.setCellFactory(ComboBoxTableCell.forTableColumn("Ja", "Nej"));
        AddKurs.getItems().addAll("Ja","Nej");
        AddKategori.getItems().addAll("Bok", "Film", "Tidning", "Tidsskrift");
    }    

    
    //Följande metoder redigerar attribut i tabellen. Textfält sparas i databasen när man klickar enter och combobox sparas direkt.
    @FXML
    private void EditKategori(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        
        String NewKategori = new String();
        
        switch (event.getNewValue().toString()){
            case "Bok":
                NewKategori = "1";
                break;
                
            case "Film":
                NewKategori = "2";
                break;
                
            case "Tidning":
                NewKategori = "3";
                break;
                
            case "Tidsskrift":
                NewKategori = "4";
                break;
        }
        Objekt.DBUpdateKategori(PrimaryKey, NewKategori);
    }
    
    @FXML
    private void EditKurs(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        
        String NewKurs = new String();
        
        switch (event.getNewValue().toString()) {
            case "Ja":
                NewKurs = "1";
                break;
            
            case "Nej":
                NewKurs = "0";
                break;
        }
        Objekt.DBUpdateKurs(PrimaryKey, NewKurs);
    }
    
    @FXML
    private void EditTitel(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewTitel = event.getNewValue().toString();
        Objekt.DBUpdateTitel(PrimaryKey, NewTitel);  
    }

    @FXML
    private void EditNamn(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewNamn = event.getNewValue().toString();
        Objekt.DBUpdateNamn(PrimaryKey, NewNamn);
    }

    @FXML
    private void EditGenre(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewGenre = event.getNewValue().toString();
        Objekt.DBUpdateGenre(PrimaryKey, NewGenre);
    }

    @FXML
    private void EditAmne(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewAmne = event.getNewValue().toString();
        Objekt.DBUpdateAmne(PrimaryKey, NewAmne);
    }
    
    @FXML
    private void EditPlacering(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewPlacering = event.getNewValue().toString();
        Objekt.DBUpdatePlacering(PrimaryKey, NewPlacering);
    }
    
    @FXML
    private void EditID(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewISBN = event.getNewValue().toString();
        Objekt.DBUpdateISBN(PrimaryKey, NewISBN);
    }
    
    @FXML
    private void EditLand(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewLand = event.getNewValue().toString();
        Objekt.DBUpdateLand(PrimaryKey, NewLand);
    }
    
    @FXML
    private void EditAlder(CellEditEvent event) {
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        int PrimaryKey = SelectedObjekt.getObjektID();
        String NewAlder = event.getNewValue().toString();
        Objekt.DBUpdateAlder(PrimaryKey, NewAlder);
    }
    
    
    private final ObservableList<Objekt> ResultList = FXCollections.observableArrayList();

    //Sökning med klassen Objekt, och fyller tabell med data. Detaljerad beskrivning av searchFunction finns i Main.
    @FXML
    private void TrySearch(MouseEvent event) {
        
        String searchParameter = null;
        String tableVariant = "Objekt";

        TextField[] SearchField     = {ID,              Titel,              Namn,               Genre,              Amne                };
        String[] FieldAttribute     = {"ID",            "titel",            "namn",             "genre",            "amnesord"          };
        
        TableColumn[] Columns       = {ColumnTitel,     ColumnGenre,        ColumnNamn,         ColumnAmne,         ColumnLand,      ColumnPlats,        ColumnKurs,         ColumnID,      ColumnAlder,    ColumnKategori    };
        String[] ColumnAttribute    = {"titel",         "genre",            "namn",             "amne",             "land",          "placering",        "kurs",             "ISBN",        "alder",        "kategori"        };
        
        table = searchFunction(Columns, ColumnAttribute, table, ResultList, SearchField, FieldAttribute, searchParameter, tableVariant, getCurrentUser());
    }

    //Lägger till objekt i databas med addPost() i Objekt.
    @FXML
    private void AddPost(MouseEvent event) {
        
        String NewTitel     = AddTitel.getText();
        String NewNamn      = AddNamn.getText();
        String NewGenre     = AddGenre.getText();
        String NewAmne      = AddAmne.getText();
        String NewPlacering = AddPlacering.getText();
        String NewID        = AddID.getText();
        String NewLand      = AddLand.getText();
        String NewAlder     = AddAlder.getText();
        
        String NewKategori = new String();
        
        switch (AddKategori.getSelectionModel().getSelectedItem()) {
            case "Bok":
                NewKategori = "1";
                break;
                
            case "Film":
                NewKategori = "2";
                break;
                
            case "Tidning":
                NewKategori = "3";
                break;
                
            case "Tidsskrift":
                NewKategori = "4";
                break;
        }
        
        String NewKurs = new String();
        
        switch (AddKurs.getSelectionModel().getSelectedItem()){
            case "Ja":
                NewKurs = "1";
                break;
                
            case "Nej":
                NewKurs = "0";
                break;
        }
        Objekt.AddPost (NewTitel, NewNamn, NewGenre, NewAmne, NewPlacering, NewID, NewLand, NewAlder, NewKategori, NewKurs);
        
        
        //Lägger till kopior.
        try {
            Connection connection = DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
            String SQL = "SELECT objektID FROM objekt WHERE ID = '" + NewID + "' AND titel = '" + NewTitel + "'";
            ResultSet result = statement.executeQuery(SQL);
            result.next();
            String objektID = result.getString("objektID");
            SQL = "INSERT INTO kopia (objektID) VALUES (" + objektID + ")";
            
            for (int counter = 0; counter < Integer.parseInt(copies.getText()); counter++) {
                
                statement.executeUpdate(SQL);
            }
        }
        catch (SQLException e){
            HandleExceptions(e);
        }
    }

    //Tar bort objekt med DeletePost().
    @FXML
    private void RemovePost(MouseEvent event) {
        
        Objekt SelectedObjekt = table.getSelectionModel().getSelectedItem();
        Objekt.DeletePost(SelectedObjekt.getObjektID()); 
    }

    //Går tillbaka till mina sidor.
    @FXML
    private void GoBack(MouseEvent event) {
        try {
            App.setRoot("MinaSidor");
            
        } catch (IOException e) {
            HandleExceptions(e);
        }
    }
    
}