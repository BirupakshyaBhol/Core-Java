package module5.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Demostrates Binary File Handling
 * @author pbose
 *
 */
public final class BinaryFileHandler 
{
	private static final int BUFFER_SIZE = 1024; // 1KB 

	/**
	 * Copies the file from the source to destination.
	 * @param srcName
	 * @param destName
	 * @return The number of bytes written to the file.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static long copy(String srcName, String destName) throws FileNotFoundException, IOException
	{
		long bytesWritten = 0;
		int bytesRead = 0;
		byte[] buffer = new byte[BUFFER_SIZE];
		File fSrc = new File(srcName), fDest = new File(destName);
		
		try(
				BufferedInputStream instream = new BufferedInputStream(new FileInputStream(fSrc));
				BufferedOutputStream outstream = new BufferedOutputStream(new FileOutputStream(fDest))
			)
		{
			while ((bytesRead = instream.read(buffer, 0, BUFFER_SIZE)) != -1)
			{
				outstream.write(buffer, 0, bytesRead);
				bytesWritten += bytesRead;
			}
		}
		
		return bytesWritten;
	}
	
	public static void main(String[] args) 
	{
		if (args.length != 2)
		{
			System.out.println("Usage: java module6.BinaryFileHandler source_filename dest_filename");
			System.exit(-1);
		}
		
		try {
			System.out.println("Bytes written:" + BinaryFileHandler.copy(args[0], args[1]));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}
}
