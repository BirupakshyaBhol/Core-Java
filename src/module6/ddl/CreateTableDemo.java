package module6.ddl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class CreateTableDemo 
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
			String sqlStmt = "CREATE TABLE test (ID INT PRIMARY KEY , NAME VARCHAR(20))";
			Statement stmt = conn.createStatement();
			stmt.execute(sqlStmt);
			System.out.println("Table created.");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
