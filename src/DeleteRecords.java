import java.sql.*;
public class DeleteRecords {
	
	public static void main(String args[]) throws Exception {
		
        String url="jdbc:mysql://127.0.0.1:3306/databasedemo";
		
		String userName="root";
		
		String password="admin";
		
		String query="delete from stud1 where stud_id='6'";
		
		Connection con=DriverManager.getConnection(url, userName, password);
		
		Statement st=con.createStatement();
		
		int rows=st.executeUpdate(query);
		
		System.out.println("No of rows affected: "+rows);
		
		
		con.close();
	}

}
