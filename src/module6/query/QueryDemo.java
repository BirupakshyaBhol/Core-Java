package module6.query;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class QueryDemo 
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
			String sqlStmt = "SELECT world.country.name, world.country.continent FROM world.country WHERE world.country.name LIKE 'A%'";
			Statement stmt = conn.createStatement();
			
			try (ResultSet set = stmt.executeQuery(sqlStmt);)
			{
				int counter = 0;
				while (set.next())
				{
					counter++;
					System.out.println(set.getString(1) + " " + set.getString(2));
				}
				
				System.out.println("Fetched " + counter + " rows.");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Query failed.");
			e.printStackTrace();
		}
	}
}
