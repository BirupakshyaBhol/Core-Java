package module7.ni;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * A class that retrieves the list of Network Interfaces and displays them on the console.
 * @author pbose
 *
 */
public final class QueryNetworkInterface 
{
	public static void main(String[] args) 
	{
		try 
		{
			Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
			NetworkInterface element = null;
			InetAddress address = null;
			
			while (ni.hasMoreElements())
			{
				element = ni.nextElement();
				System.out.println("*** Network Interface ***");
				System.out.println(element.getDisplayName());
				
				Enumeration<InetAddress> address_list = element.getInetAddresses();
				while (address_list.hasMoreElements())
				{
					address = address_list.nextElement();
					System.out.println("InetAddress -> " + address.getHostAddress());
				}
				
				System.out.println();
			}
		} 
		catch (SocketException e) 
		{
			e.printStackTrace();
		}
	}
}
