package module7.udp.unicast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Properties;

import module7.Constants;

import org.apache.log4j.Logger;

/**
 * Unicast message listener
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

		int port = Integer.valueOf(p.getProperty(Constants.UDP_PORT));
	
		// create a Datagram socket and bind it to the port
		try(DatagramSocket client = new DatagramSocket(port);)
		{
			// create buffer for unicast message
			byte [] data = new byte[Constants.DATA_SIZE];
			
			// loop to get unicast messages
			while (true)
			{
				// create a packet to receive unicast data.
				// as the socket is bound to the port no need to send the ip address and port#
                DatagramPacket packet = new DatagramPacket(data, data.length);
				try 
				{ 
					// this is a blocking call, waits for unicast messages 
					logger.debug("Waiting for messages...");
					client.receive(packet);
					
					// extract data and display it
					String str = new String(packet.getData(), 0, packet.getData().length);
					System.out.println("*** Data Received -> " + str);
				} 
				catch (IOException e) 
				{
					logger.error("Error receiving packet.");
					e.printStackTrace();
				}
			}
		} 
		catch (SocketException e) 
		{
			logger.error("Could not create receiver datagram socket.");
			e.printStackTrace();
		}
	}
}
