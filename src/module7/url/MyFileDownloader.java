package module7.url;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public final class MyFileDownloader 
{
	private static String spec = "http://www.oracle.com/events/global/en/java-outreach/resources/java-a-beginners-guide-1720064.pdf";
	
	public static void main(String[] args) 
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java module9.url.DownloadRFCFromURL download_to_folder");
			System.out.println("Example: java module9.url.DownloadRFCFromURL c:/downloads/");
			System.exit(-1);
		}
		
		try 
		{
			// create url object
			URL url = new URL(spec);
			// extract filename
			String filename = spec.substring(spec.lastIndexOf('/')+1, spec.length());
			
			File f = new File(args[0] + filename);
			
			// create a binary out stream to write the contents of the url
			try (BufferedOutputStream ostream = new BufferedOutputStream(new FileOutputStream(f));)
			{
				System.out.println("Downloading to " + f.toString());
				// get the url connection
				URLConnection conn = url.openConnection();
				
				// get the content length
				float total_size = conn.getContentLength();
				// download % counter
				float fDonwloaded = 0;
				
				// get the url stream from the connection
				InputStream url_stream = conn.getInputStream();
				
				byte [] buffer = new byte[20480]; // 20 KB chunks
				int count = 0;
				// loop to read from the url
				while ((count = url_stream.read(buffer, 0, buffer.length)) != -1)
				{
					// write to the file
					ostream.write(buffer, 0, count);
					
					// calculate and print the download progress
					fDonwloaded += ((count/total_size)*100);
					System.out.printf("Downloaded: %.2f%%\n", fDonwloaded);
				}
				System.out.println("Finished downloading.");
			}			
			catch (IOException e) 
			{
				System.out.println("Error reading streams.");
				e.printStackTrace();
			}
		} 
		catch (MalformedURLException e) 
		{
			System.out.println("Malformed URL spec.");
			e.printStackTrace();
		}
	}
}
