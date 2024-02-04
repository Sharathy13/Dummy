

import java.sql.*;
public class DeleteTable {
	
	public static void delete() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
        String userName = "root";
        String password = "admin";
        String query = "delete from tickets where ticket_no='2'";
        
        Connection con=DriverManager.getConnection(url, userName, password);
        PreparedStatement pst=con.prepareStatement(query);
        pst.executeUpdate();
        con.close();
        
	}
	
	public static void main(String args[]) throws Exception {
		delete();
	}

}
