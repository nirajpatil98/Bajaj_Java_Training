package demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestJdbc {

	public static void main(String[] args) {

		Connection con = null;
		String cs = "jdbc:postgresql://localhost:5432/dbfinserv";
		String query = "Insert into employee values(24,'Vishal',25)";
		String queryUpdate = "Update employee set ename = 'Niraj' where eid = 7"
;		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int x = sc.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(cs,"postgres","Finserv@2023");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM employee WHERE eid = " + x);
			while (rs.next()) {
			    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			int count = st.executeUpdate(query);
			System.out.println( "number of rows affected by this query= " + count);
			
			count = 0;
			count = st.executeUpdate(queryUpdate);
			System.out.println( "number of rows affected by this query= " + count);
		} 
		catch (Exception e) {
			
		}
		
	}

}