package Java2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;

public class RegistreraController extends Main implements Initializable {

    @FXML
    private PasswordField Password;
    @FXML
    private TextField Username;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField Phone;
    @FXML
    private TextField Mail;
    @FXML
    private TextField Adress;
    @FXML
    private ChoiceBox<String> RoleChoice;
    private String felmeddelande;

    public String getFelmeddelande() {
        return felmeddelande;
    }

    public void setFelmeddelande(String felmeddelande) {
        this.felmeddelande = felmeddelande;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Stoppar in värden i choicebox.
        RoleChoice.getItems().add("Anställd");
        RoleChoice.getItems().add("Student");
    }

    //Metoden för registreringsknappen.
    @FXML
    private void TryRegister(MouseEvent event) {
        int minPassLength = 8;
        int minMailLength = 8;
        String formatMail = "@";

        System.out.println(Username.getText());
        System.out.println(fName.getText());
        System.out.println(lName.getText());
        System.out.println(Phone.getText());
        System.out.println(Adress.getText());
        System.out.println(Mail.getText());
        System.out.println(Password.getText());

        //Olika kontroll för input från användare.
        try {

            if (Password.getText().length() < minPassLength) {
                setFelmeddelande("Lösenordet måste innehålla minst 8 karaktärer.");
                throw new RuntimeException();
            }

          if (Password.getText().isEmpty()) {
                setFelmeddelande("Ange ett lösenord.");
                throw new RuntimeException();

            }

            if (fName.getText().isEmpty()) {
                setFelmeddelande("Ange ditt förnamn.");
                throw new RuntimeException();
            }

            if (lName.getText().isEmpty()) {
                setFelmeddelande("Ange ditt efternamn.");
                throw new RuntimeException();
            }

            if (Mail.getText().length() < minMailLength) {
                setFelmeddelande("Mailadressen måste innehålla minst 8 karaktärer.");
                throw new RuntimeException();
            }

            if (!Mail.getText().contains(formatMail)) {
                setFelmeddelande("Fel format på mailadressen.");
                throw new RuntimeException();
            }

            if (Username.getText().isEmpty()) {
                setFelmeddelande("Ange ett önskat användarnamn.");
                throw new RuntimeException();
            }

            if (Phone.getText().isEmpty()) {
                setFelmeddelande("Ange ditt telefonnummer.");
                throw new RuntimeException();
            }

            if (Adress.getText().isEmpty()) {
                setFelmeddelande("Ange din adress.");
                throw new RuntimeException();
            }

            if (Mail.getText().isEmpty()) {
                setFelmeddelande("Ange din email-adress.");
                throw new RuntimeException();
            }

            String anvandarnamn = Username.getText();
            String fNamn = fName.getText();
            String eNamn = lName.getText();
            String telNr = Phone.getText();
            String gatuadress = Adress.getText();
            String eMail = Mail.getText();
            String losenord = Password.getText();
            String kategoriseringAnvID;
            String anstalld;

            Registrera registrering = new Registrera();
            if (RoleChoice.getSelectionModel().getSelectedItem().equals("Anställd")) {
                kategoriseringAnvID = "2";
                anstalld = "1";
            } else {
                kategoriseringAnvID = "1";
                anstalld = "0";
            }
            
            Registrera.insertRecord(anvandarnamn, losenord, fNamn, eNamn, telNr, gatuadress, eMail, kategoriseringAnvID, anstalld);
            
            showAlert(Alert.AlertType.CONFIRMATION, "Registrering klar",
                    "Välkommen " + fName.getText());

        } catch (RuntimeException e) {

            HandleExceptions(e);
            
            showAlert(Alert.AlertType.ERROR, "Fel",
                    felmeddelande);
        }
    }

    
    //Metod för felmeddelande i registreringen.
    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    //Avbryter registrering.
    @FXML
    private void TryCancel(MouseEvent event) {

        showAlert(Alert.AlertType.CONFIRMATION, "Registrering avbruten",
                "Registrering avbruten");
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }
}
