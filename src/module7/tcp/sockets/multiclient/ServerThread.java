package module7.tcp.sockets.multiclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import module7.Constants;

import org.apache.log4j.Logger;

/**
 * Thread to handle a socket client.
 * @author pbose
 *
 */
public class ServerThread implements Runnable
{
	/**
	 * Keeps the count of the number of connections
	 */
	private static int client_count = 0;
	private static final Logger logger = Logger.getLogger(ServerThread.class.getName());
	protected Socket client = null;
	
	/**
	 * 
	 * @param client client socket instance
	 */
	public ServerThread(Socket client)
	{ this.client = client; }
	
	@Override
	public void run() 
	{	
		// increment the counter when connected to a client
		client_count++;
		logger.debug("Connected to " + client.toString());	
		
		// get the client socket I/O streams
		try(PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));)
		{
			// send a welcome message to the client
			out.println("Welcome! You are connection # " + client_count);

			String client_msg = null;
			
			// loop to read messages from the client
			while ((client_msg = in.readLine()) != null)
			{
				// echo the message from the client
				System.out.println("*** Message from " + client.toString() + " -> " + client_msg);
				// Acknowledge the message
				out.println("Acknowledged.");

				// code to exit the loop
				if (client_msg.compareToIgnoreCase(Constants.EXIT_CMD) == 0) 
				{
					logger.debug("Closing connection with " + client.toString());
					client_count--;
					break;
				}
			}
		} 
		catch (IOException e) 
		{
			logger.error("Lost connection to host due to I/O error.");
			e.printStackTrace();
		} 
	}
}
