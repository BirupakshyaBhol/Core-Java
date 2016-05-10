package module7.udp.multicast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Properties;

import module7.Constants;

import org.apache.log4j.Logger;

public final class Client 
{
	private static final Logger logger = Logger.getLogger(Client.class.getName());
	// properties file for connections.
	private static final String CONN_FILE = "resources/conn.properties";
	
	public static void main(String[] args) 
	{
		if (args.length != 1)
		{
			System.out.println("Usage java <classpath> module9.udp.multicast.Client num_of_msg_to_receive");
			System.exit(-1);
		}
		
		int num_of_msg = Integer.parseInt(args[0]);
		logger.debug("Number of messages to receive: " + num_of_msg);
		
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
		
		InetAddress mcastaddr = null;
		try 
		{
			mcastaddr = InetAddress.getByName(p.getProperty(Constants.MULTICAST_IP));
		} 
		catch (UnknownHostException e1) 
		{
			logger.error("Could not find host:" + p.getProperty(Constants.MULTICAST_IP));
			e1.printStackTrace();
			System.exit(-1);
		}
		
		try(MulticastSocket client = new MulticastSocket(port);)
		{
			client.joinGroup(mcastaddr);
			logger.debug("Joined group " + mcastaddr.toString());
			
			// create buffer for multicast message
			byte [] data = new byte[Constants.DATA_SIZE];
			
			// loop to get multicast messages
			for (int i = 0; i < num_of_msg; i++)
			{
				// create a packet to receive multicast data.
				// as the socket is bound to the port no need to send the ip address and port#
                DatagramPacket packet = new DatagramPacket(data, data.length);
				try 
				{ 
					// this is a blocking call, waits for multicast messages 
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
			
			client.leaveGroup(mcastaddr);
			logger.debug("Left group " + mcastaddr.toString());
		} 
		catch (IOException e) 
		{
			logger.error("Could not create a multicast receiver.");
			e.printStackTrace();
		}
	}
}
