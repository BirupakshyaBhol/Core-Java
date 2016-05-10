package module6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Demonstrates how to connect to a database.
 * @author pbose
 *
 */

public final class TestConnection 
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

		System.out.println("Connecting to database.");
		try(Connection conn = DriverManager.getConnection(p.getProperty("url"), p);)
		{
			System.out.println("Connection succeeded.");
		} 
		catch (SQLException e) 
		{
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		finally
		{ System.out.println("Connection closed."); }
	}
}
