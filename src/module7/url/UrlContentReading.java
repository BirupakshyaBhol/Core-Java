package module7.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public final class UrlContentReading 
{
	private static String spec = "http://www.ietf.org/rfc/rfc2616.txt";
	
	public static void main(String[] args) 
	{
		try 
		{
			URL url = new URL(spec);
			int count = 0;
			byte [] buffer = new byte[1024];
			
			InputStream istream = url.openStream();
			while ((count = istream.read(buffer, 0, buffer.length)) != -1)
			{
				String content = new String(buffer, 0, count);
				System.out.println(content);
			}
		} 
		catch (MalformedURLException e) 
		{
			System.out.println("Malformed URL spec.");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println("Error reading streams.");
			e.printStackTrace();
		}
	}
}
