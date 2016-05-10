package module7.udp.unicast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;

import module7.Constants;

import org.apache.log4j.Logger;

/**
 *  A server that unicasts random numbers
 * @author pbose
 *
 */
public final class Server 
{
	private static final Logger logger = Logger.getLogger(Server.class.getName());
	// properties file for connections.
	private static final String CONN_FILE = "resources/conn.properties";
	
	private static int LOOP_SIZE = 100;
	
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

		// get the port and the ip address
		int port = Integer.valueOf(p.getProperty(Constants.UDP_PORT));
		InetAddress laddr = null;
		try 
		{
			laddr = InetAddress.getByName(p.getProperty(Constants.HOST));
		} 
		catch (UnknownHostException e1) 
		{
			logger.error("Could not find host:" + p.getProperty(Constants.HOST));
			e1.printStackTrace();
			System.exit(-1);
		}
		
		// create a Datagram socket, dont bind it to the port
		try(DatagramSocket server = new DatagramSocket();)
		{
			logger.debug("Unicasting " + LOOP_SIZE + " random numbers...");
			// unicast N random numbers
			for (int i = 0; i < LOOP_SIZE; i++)
			{
				// prepare data
				String data = Integer.toString((int)(Math.random() * 10000));
				logger.debug("Unicast data -> " + data);
				
				// create a packet with data, ip address and port#
				DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, laddr, port);
								
				// send to receivers
				server.send(packet);
				
				// just taking rest for 1s 
				try 
				{ Thread.sleep(1000); } 
				catch (InterruptedException e) 
				{ logger.debug("Sleep timeout failed."); }
			}
		} 
		catch (SocketException e) 
		{
			logger.error("Could not create sender datagram socket.");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			logger.error("Error sending data packet.");
			e.printStackTrace();
		}
	}
}
