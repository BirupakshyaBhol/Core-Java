package module6.dml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public final class UpdateTableDemo 
{
	// properties file where database URL, user & password is stored.
	private static final String DB_CONN_FILE = "resources/dbcon.properties";
	
	public static void main(String[] args) 
	{
		Properties p = new Properties();		
		// Load the properties file
		try 
		{
			p.load(new FileInputStream(new File(DB_CONN_FILE)));
		} 
		catch (IOException e) 
		{
			System.out.println("Error reading " + DB_CONN_FILE);
			e.printStackTrace();
			System.exit(-1);
		}

		try(Connection conn = DriverManager.getConnection(p.getProperty("url"), p);)
		{
			String sqlStmt = "UPDATE test.student SET test.student.name = ? where test.student.ID = ?";
			
			try(PreparedStatement stmt = conn.prepareStatement(sqlStmt);)
			{
				stmt.setString(1, "John Forbes Nash"); // setting value for the first ?
				stmt.setInt(2, 1); // setting value for the second ?
				int r = stmt.executeUpdate();
				
				System.out.println("Updated " + r + " row(s).");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Update failed.");
			e.printStackTrace();
		}
	}
}
