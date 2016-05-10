package module5.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Class for listing files in a folder non-recursively.
 * @author pbose
 *
 */
public final class FileListing 
{
	public static String [] list(final String folder, final String filter)
	{
		File f = new File(folder);
		String [] fileList = f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) 
			{ return name.endsWith(filter); }
		});
		
		return fileList;
	}
	
	public static void main(String[] args) 
	{
		if (args.length != 2)
		{
			System.out.println("Usage: java module6.FileListing folder extension");
			System.out.println("Example: java module6.FileListing /documents .java");
			System.exit(-1);
		}
		
		// Get the file list
		String [] listing = FileListing.list(args[0], args[1]);
		if (listing != null)
		{
			// Display it.
			for (String s : listing)
				System.out.println(s);
		}
		else System.out.println("No files found.");
	}
}
