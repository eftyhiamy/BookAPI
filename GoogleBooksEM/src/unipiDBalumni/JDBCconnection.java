package unipiDBalumni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCconnection {
	public static void main(String[] args) {
		//create a variable for the connection string.
		String url = "jdbc:sqlserver://LAPTOP-1UJ09VIJ:1433;databaseName=unipi_alumni;User=unipiProject;Password=unipi123";
		//Declare JDBC object.
		Connection con = null;
		
		//Establish the connection.
		try{
			con = DriverManager.getConnection(url);
		
		//Iterate through the data in the result set and display it.
		
		//Insert one record to  the DB.
		String ins = "Insert into STUDENTSdetails (STUDENTNAME, STUDENTSURNAME, STUDENTFNAME, EMAIL, BIRTHDAY) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(ins);
		Date date = new Date(19921020);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		ps.setString(1, "Anna");
		ps.setString(2, "Panagiotou");
		ps.setString(3, "Alkis");
		ps.setString(4, "annapana@gmail.com");
		ps.setDate(5, sqlDate);
		ps.executeUpdate();
		ps.close();
		
		
		// Create and execute an SQL statement that returns some data.
		String sel = "Select * from STUDENTSdetails";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sel);
		while (rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(5));
		}
		
		//Delete records from a table.
		String del = "Delete from STUDENTSdetails";
		PreparedStatement psb = con.prepareStatement(del);
		psb.executeUpdate();
		psb.close();
		
		//Insert multiple records to the DB.
		String insmultiple = "Insert into STUDENTSdetails (STUDENTNAME, STUDENTSURNAME, STUDENTFNAME, EMAIL, BIRTHDAY) VALUES (?,?,?,?,?)";
		BufferedReader csvReader = new BufferedReader(new FileReader("students.txt"));
		String row = "";
		PreparedStatement psc = null;
		while (row = csvReader.readLine()) !=null) {
			String[] data = row.split(",");
			PreparedStatement psc1 = con.prepareStatement(ins);
			Date date1 = new Date(19921020);
		    java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
		    psc1 = con.prepareStatement(ins);
			psc1.setString(1, data[0] );
			psc1.setString(2, data[1]);
			psc1.setString(3, data[2]);
			psc1.setString(4, data[3]);
			psc1.setDate(5, data[4]);
			psc1.executeUpdate();
		}
		
		ps.close();
		st.close();
		rs.close();
		psb.close();
		psc1.close();
		
		//Insert multiple records to the DB efficiently.
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
