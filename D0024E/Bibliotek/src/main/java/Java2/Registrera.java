package Java2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Registrera extends Main {


    //Metod för att bygga SQL sats för en ny användare.
    private static final String QUERY(String anvandarnamn, String losenord, String fNamn, String eNamn,  String telNr, String gatuadress,  String eMail, String kategoriseringAnvID, String anstalld) {
        String QUERY =  "INSERT INTO anvandare (anvandarnamn, losenord, fNamn, eNamn, telNr, gatuadress, eMail, kategoriseringAnvID, anstalld) "
                        + "VALUES ('" + anvandarnamn + "','" + losenord + "','" + fNamn + "','" + eNamn + "','" + telNr + "','" + gatuadress + "','" + eMail + "','" + kategoriseringAnvID + "','" + anstalld + "');";
        return QUERY;
    }


    //Kör SQL sats för att stoppa in användare i databas.
    public static void insertRecord(String anvandarnamn, String losenord, String fNamn, String eNamn,  String telNr, String gatuadress,  String eMail, String kategoriseringAnvID, String anstalld) {
        try {
            Connection connection = DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPass());

            String query = QUERY(anvandarnamn, losenord, fNamn, eNamn, telNr, gatuadress, eMail, kategoriseringAnvID, anstalld);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
           

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

