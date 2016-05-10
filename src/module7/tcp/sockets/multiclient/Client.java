package module7.tcp.sockets.multiclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import module7.Constants;

import org.apache.log4j.Logger;

/**
 * Client socket class sending messages to a socket server.
 * @author pbose
 *
 */
public final class Client 
{
	private static final Logger logger = Logger.getLogger(Client.class.getName());
	// properties file for connections.
	private static final String CONN_FILE = "resources/conn.properties";

	public static void main(String[] args) 
	{
		Properties p = new Properties();		
		// Load the properties file
		try 
		{
			p.load(new FileInputStream(new File(CONN_FILE)));
		} 
		catch (IOException e) 
		{
			logger.debug("Error reading " + CONN_FILE);
			e.printStackTrace();
			System.exit(-1);
		}
		
		String host = p.getProperty(Constants.HOST);
		int port = Integer.valueOf(p.getProperty(Constants.TCP_PORT));
		
		try (Socket client = new Socket(host, port);)
		{
			try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in));)
			{
				logger.debug("Connected to host=" + host + " on port=" + port);

				String str = null;
				
				// get the socket I/O streams
				try(PrintWriter out = new PrintWriter(client.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));)
				{
					// print the welcome message from the server
					System.out.println("*** Feedback from server -> " + in.readLine());
					// enter a message to be sent to the server
					System.out.print("Enter text to send to server (type #exit to quit application) -> ");
	
					while ((str = input.readLine()) != null)
					{
						// send the message to the server
						out.println(str);
						// print the message from the server
						System.out.println("*** Feedback from server -> " + in.readLine());

						// code to exit the loop
						if (str.compareToIgnoreCase(Constants.EXIT_CMD) == 0) 
						{
							logger.debug("Exiting...");
							break;
						}
						else
							System.out.print("Enter text to send to server (type #exit to quit application -> ");
					}
				}
			}
		} 		
		catch (UnknownHostException e) 
		{
			logger.error("Could not connect to host.");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			logger.error("Lost connection to host due to I/O error.");
			e.printStackTrace();
		}
	}
}
