package module7.url;

import java.net.MalformedURLException;
import java.net.URL;

public final class UrlParsing 
{
	public static void main(String[] args) 
	{
		String spec = "http://rayli.net/blog/data/top-10-data-mining-algorithms-in-plain-english/?imm_mid=0d28ad&cmp=em-data-na-na-newsltr_20150527";
		URL url;
		try 
		{
			url = new URL(spec);
			
			System.out.println("Protocol = " + url.getProtocol());
	        System.out.println("Host = " + url.getHost());
	        System.out.println("Path = " + url.getPath());
	        System.out.println("Query String = " + url.getQuery());
		} 
		catch (MalformedURLException e) 
		{
			System.out.println("Malformed URL spec.");
			e.printStackTrace();
		}
	}
}
