import java.sql.*;
public class Updatemovie {
	
	public static void update() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
        String userName = "root";
        String password = "admin";
        String query = "update tickets set ticket_no='2' where screen_no='4'";
        
        Connection con=DriverManager.getConnection(url, userName, password);
        PreparedStatement pst=con.prepareStatement(query);
        pst.executeUpdate();
        con.close();
        
	}
	
	public static void main(String args[]) throws Exception {
		update();
	}

}
