package module7.tcp.sockets;

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
		
		// create a client socket
		try (Socket client = new Socket(host, port);)
		{
			// open a stream for console input
			try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in));)
			{
				logger.debug("Connected to host=" + host + " on port=" + port);
				
				// get the client socket I/O streams
				try(PrintWriter out = new PrintWriter(client.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));)
				{
					System.out.print("Enter text to send to server -> ");
					// send a message to the server
					String str = input.readLine();
					// print the message from the server
					out.println(str);
					
					System.out.println("*** Feedback from server -> " + in.readLine());
					logger.debug("Exiting client...");
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
