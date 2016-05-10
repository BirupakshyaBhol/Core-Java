package module6.proc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class InParamDemo 
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
			try(CallableStatement proc = conn.prepareCall("CALL insert_student (?, ?)");)
			{
				proc.setInt(1, 4);
				proc.setString(2, "David Attenborough");
				
				proc.execute();
				System.out.println("Success calling insert_student(...)");
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Stored procedure call failed.");
			e.printStackTrace();
		}
	}
}
