import java.sql.*;

public class JDBC {
	
	public static void main(String args[]) throws Exception {
		
		String url="jdbc:mysql://127.0.0.1:3306/databasedemo";
		
		String userName="root";
		
		String password="admin";
		
		String query="select * from employ";
		
		Connection con=DriverManager.getConnection(url, userName, password);
		
		Statement st=con.createStatement();
		
		ResultSet rs= st.executeQuery(query);
		
		while(rs.next()) {
		
		System.out.println("Id is "+rs.getInt(1));
		
		System.out.println("Name is "+rs.getString(2));
		
		System.out.println("Salary is "+rs.getInt(3));
		
		};
		con.close();
		
		
		
		
		
		
		
		
		
	}

}
