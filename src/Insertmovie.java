import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insertmovie {

    public static void insert() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
        String userName = "root";
        String password = "admin";
        String query = "insert into tickets values(?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, 2);
            pst.setString(2, "Kannagi");
            pst.setInt(3, 2);
            pst.setInt(4, 1);

            pst.executeUpdate();
        } // The try-with-resources statement automatically closes resources

    }

    public static void main(String args[]) throws Exception {
        insert();
    }

}

