package module6.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Properties;

public final class BatchProcessDemo 
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
			Savepoint marker = null;
			conn.setAutoCommit(false);
			
			String stmt = "INSERT INTO student VALUES (?, ?)";
			
			try(PreparedStatement cmd = conn.prepareStatement(stmt);)
			{
				// start transaction
				marker = conn.setSavepoint("start_trans");
				
				// first set of records
				cmd.setInt(1, 5);
				cmd.setString(2, "Radhanath Sikdar");
				cmd.addBatch();
				
				// second set of records
				cmd.setInt(1, 6);
				cmd.setString(2, "Karl Sagan");
				cmd.addBatch();
				
				System.out.println("Executing batch.");
				int [] count = cmd.executeBatch();
				System.out.println("Inserted " + count.length + " record(s).");

				conn.commit();
				System.out.println("Committed transaction.");
				// ending transaction
				conn.releaseSavepoint(marker);
				conn.setAutoCommit(true);
			}
			catch (SQLException e) 
			{
				System.out.println("Batch processing failed.");
				e.printStackTrace();
				
				if (marker != null)
					conn.rollback(marker);
				
				System.out.println("Rolled back transaction.");
				conn.setAutoCommit(true);
			}
			
		}
		catch (SQLException e) 
		{
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
}
