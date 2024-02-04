import java.sql.*;
public class GetMovie {
	
	public static void main(String args[]) throws Exception{
        String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
        String userName = "root";
        String password = "admin";
        String query = "select * from tickets";
        
        Connection con=DriverManager.getConnection(url, userName, password);
        Statement sts=con.createStatement();
        ResultSet rs=sts.executeQuery(query);
        while(rs.next()) {
        	System.out.println("ticket no:"+rs.getInt(1));
        	System.out.println("Movie Name:"+rs.getString(2));
        	System.out.println("Seat No:"+rs.getInt(3));
        	System.out.println("Screen NO::"+rs.getInt(4));
        	
        
        
        
	}
        con.close();
	
	

}

}
