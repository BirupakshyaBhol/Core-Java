package module7.tcp.sockets.multiclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import module7.Constants;

import org.apache.log4j.Logger;

/**
 * Multi-threaded server socket.
 * Echoes the message from the client.
 * @author pbose
 *
 */
public final class Server 
{
	private static final Logger logger = Logger.getLogger(Server.class.getName());
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
			logger.error("Error reading " + CONN_FILE);
			e.printStackTrace();
			System.exit(-1);
		}
		
		int port = Integer.valueOf(p.getProperty(Constants.TCP_PORT));
		
		try(ServerSocket server = new ServerSocket(port);)
		{
			while(true)
			{
				logger.debug("Waiting for connection...");
				// wait for connection, this is a blocking call, i.e. waits for new connections
				Socket client = server.accept();	
			    // spawn a thread to handle a socket client
			    new Thread(new ServerThread(client)).start();		  
			}
		} 
		catch (IOException e) 
		{
			logger.error("Lost connection to host due to I/O error.");
			e.printStackTrace();
		} 
	}
}
