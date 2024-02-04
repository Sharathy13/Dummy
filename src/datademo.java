import java.sql.*;

public class datademo {
	
	public static void main(String args[]) throws Exception{
		
		String url="jdbc:mysql://127.0.0.1:3306/databasedemo";
		
		String userName="root";
		
		String password="admin";
		
		String query="select * from stud1";
		
		Connection con=DriverManager.getConnection(url, userName, password);
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			
			System.out.println("Student id: " +rs.getInt(1));
			
			System.out.println("Student name: " +rs.getString(2));
			
			System.out.println("GPA: " +rs.getInt(3));
		}
		
		con.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
