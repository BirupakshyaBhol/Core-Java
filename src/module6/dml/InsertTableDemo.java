package module6.dml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public final class InsertTableDemo 
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
			String sqlStmt = "INSERT INTO test.student VALUES(?, ?)";
			
			try(PreparedStatement stmt = conn.prepareStatement(sqlStmt);)
			{
				stmt.setInt(1, 2); // setting value for the first ?
				stmt.setString(2, "PC Mahalanobis"); // setting value for the second ?
				int r = stmt.executeUpdate();
				
				System.out.println("Inserted " + r + " row(s).");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Insert failed.");
			e.printStackTrace();
		}
}
}
