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
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UtloggadController extends Main implements Initializable{
    
    @FXML
    private PasswordField Password;
    @FXML
    private TextField Username;
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
    
    
    //Metoden för inloggning. Stoppar även in värde för currentuser och anstalld i Main.
    @FXML
    private void TryLogin(MouseEvent event) {
        
        String SQL =    "SELECT anvandarID, anstalld\n" +
                        "FROM anvandare\n" +
                        "WHERE anvandarnamn = BINARY '" + Username.getText() + "'\n" +
                        "AND losenord = BINARY '" + Password.getText() + "'";
        
        try {
            Connection connection = DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPass());
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet result = statement.executeQuery(SQL);
            
            result.beforeFirst();
            result.next();
            
            if (result.getInt("anstalld") == 1) {
                setAnstalld(true);
            }
            
            setCurrentUser(result.getInt("anvandarID"));
            
            try {
                App.setRoot("inloggad");
                
            }                
            catch(IOException e){
                HandleExceptions(e);
            }                    
        }
        catch (SQLException e) {
            HandleExceptions(e);
            AlertCreator("Error", "Fel användarnamn eller lösenord");
        }
    }
    
    //Öppnar registrering.
    @FXML
    private void Registration(MouseEvent event) {
        
        Stage stage = new Stage();
        try {           
            Scene scene = new Scene(App.loadFXML("registrera"));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();  
        }                
        catch(IOException e){
            HandleExceptions(e);
        }
    }
    
    //Gör en sökning med klassen Objekt. Ytterligare beskrivning av searchFunction finns i klassen Main.
    @FXML
    private void TrySearch(MouseEvent event) {
        
        String searchParameter = null;
        String tableVariant = "Objekt";
        
        //SearchField is an array of the search fields in the fxml, and FieldAttribute is an array of the corresponding attributes each field searches for. 
        //Both arrays require equal amount of elements, and have to be matched according to order. They match in pairs, the upper with the lower.
        
        TextField[] SearchField     = {ID,              Titel,              Namn,               Genre,              Amne                };
        String[] FieldAttribute     = {"ID",            "titel",            "namn",             "genre",            "amnesord"          };
        
        //Columns is an array of the columns that appear in the table, and ColumnAttributes is an array of the attributes that the columns display. ObjektAttributes are defined as the variables of Objekt.java, and have to be named the same.
        //Both arrays require equal amount of elements, and have to be matched according to order. They match in pairs, the upper with the lower.
        
        TableColumn[] Columns       = {ColumnGenre, ColumnTitel, ColumnNamn, ColumnAmne, ColumnTillganglig, ColumnPlats, ColumnKurs, ColumnID};
        String[] ColumnAttribute    = {"genre", "titel", "namn", "amne", "tillganglighet", "placering", "kurs", "ISBN"};
        
        table = searchFunction(Columns, ColumnAttribute, table, ResultList, SearchField, FieldAttribute, searchParameter, tableVariant, getCurrentUser());
    }
    
}