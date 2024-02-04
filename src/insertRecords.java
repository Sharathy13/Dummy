import java.sql.*;

public class insertRecords {
	
	public static void main(String args[]) throws Exception {
//		readRecords();
//		entryRecords();
//		entry1Records();
//		pstRecords();
//		updateRecords();
//		sp1();
//		sp2();
		
		batchdemo();
	}
	
	public static void readRecords() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		String query = "select * from stud1";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Student id: " + rs.getInt(1));
			System.out.println("Student name: " + rs.getString(2));
			System.out.println("GPA: " + rs.getDouble(3));
		}
		
		con.close();
	}
	
	public static void entryRecords() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		String query = "insert into stud1 values(5,'Devi',6.6)";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("No of rows affected: " + rows);
		
		con.close();
	}
	
	public static void entry1Records() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		int id=7;
		String name="Priya";
		int salary=7;
		
		
	
		String query = "insert into stud1 values("+id+",'"+name+"',"+salary+");";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("No of rows affected: " + rows);
		
		con.close();
	}
	
	public static void pstRecords() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		int id=9;
		String name="Dhivya";
		int gpa=8;
		
		
	
		String query = "insert into stud1 values(?,?,?);";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setInt(1,id);
		
		pst.setString(2,name);
		
		pst.setInt(3,gpa);
		
		int rows = pst.executeUpdate();
		
		System.out.println("No of rows affected: " + rows);
		
		con.close();
	}
	
	public static void updateRecords() throws Exception{
		
		String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		
		String query="update stud1 set stud_id='6' where name='Priya'";
		
		Connection con=DriverManager.getConnection(url, userName, password);
		
		PreparedStatement pst=con.prepareStatement(query);
		
		int rows=pst.executeUpdate();
		
		System.out.println("No of rows affected:"+rows);
		
		con.close();
		
		
		
		
	}
	
	public static void sp() throws Exception{
		
		String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		
		Connection con=DriverManager.getConnection(url, userName, password);
		
		CallableStatement cst=con.prepareCall("{call GetDetails()}");
		
		ResultSet rs=cst.executeQuery();
		
		while(rs.next()) {
			System.out.println("Student id: " + rs.getInt(1));
			System.out.println("Student name: " + rs.getString(2));
			System.out.println("GPA: " + rs.getDouble(3));
		}
		
		
		con.close();
		
		
	}
	
	public static void sp1() throws Exception{
		
		String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		int id=3;
		Connection con=DriverManager.getConnection(url, userName, password);
		
		CallableStatement cst=con.prepareCall("{call GetDetailsById(?)}");
		cst.setInt(1, id);
		ResultSet rs=cst.executeQuery();
		
		while(rs.next()) {
			System.out.println("Student id: " + rs.getInt(1));
			System.out.println("Student name: " + rs.getString(2));
			System.out.println("GPA: " + rs.getDouble(3));
		}
		
		
		con.close();
		
		
		
		
	}
	
	//calling a stored procedure with out parameter
	
public static void sp2() throws Exception{
		
		String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
		String userName = "root";
		String password = "admin";
		int id=3;
		Connection con=DriverManager.getConnection(url, userName, password);
		
		CallableStatement cst=con.prepareCall("{call GetNameById(?,?)}");
		cst.setInt(1, id);  //for input parameter
		cst.registerOutParameter(2, Types.VARCHAR);  //for output parameter
		cst.executeUpdate();
		
		System.out.println(cst.getString(2));
		
		con.close();
}

     //commit and autocommit

public static void commitdemo() throws Exception{
	
	String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
	String userName = "root";
	String password = "admin";
	String Query1="update stud1 set gpa='8' where stud_id='1'";
	String Query2="update stud1 set gpa='8' where stud_id='2'";
	
	
	Connection con=DriverManager.getConnection(url, userName, password);
	con.setAutoCommit(false);
	Statement st=con.createStatement();
	int rows1=st.executeUpdate(Query1);
	System.out.println("No of rows affected:"+rows1);
	
	int rows2=st.executeUpdate(Query1);
	System.out.println("No of rows affected:"+rows2);
	
	if(rows1>0 && rows2>0)
		con.commit();
	
	con.close();
}

//batch processing

public static void batchdemo() throws Exception{
	
	String url = "jdbc:mysql://127.0.0.1:3306/databasedemo";
	String userName = "root";
	String password = "admin";
	String Query1="update stud1 set gpa='8' where stud_id='1'";
	String Query2="update stud1 set gpa='7' where stud_id='2'";
	String Query3="update stud1 set gpa='10' where stud_id='3'";
	String Query4="update stud1 set gpa='9' where stud_id='4'";
	
	
	Connection con=DriverManager.getConnection(url, userName, password);
	con.setAutoCommit(false);
	Statement st=con.createStatement();
	st.addBatch(Query1);
	st.addBatch(Query2);
	st.addBatch(Query3);
	st.addBatch(Query4);
	
	int[] res=st.executeBatch();   //results displayed in an string array
	for(int i:res) {
//		System.out.println("Rows affected:"+res);
		
		if(i>0)
			continue;
		else
			con.rollback();
	}
	con.commit();
	
	con.close();
}




	

	
}
