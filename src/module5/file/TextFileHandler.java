package module5.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Demostrates Text File Handling
 * @author pbose
 *
 */
public final class TextFileHandler 
{
	private static String file_name = "inputs/countries.csv";
	/**
	 * Stores the CSV file in a hashmap. 
	 */
	private static HashMap<String, String> table = new HashMap<String, String>();
	
	public static HashMap<String, String> getTable()
	{ return table; }

	/**
	 * Loads the CSV file in a hashmap;
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void loadFile() throws FileNotFoundException, IOException
	{
		try(BufferedReader br = new BufferedReader(new FileReader(new File(file_name)));)
		{
			String line = null;
			while ((line = br.readLine()) != null)
			{
				StringTokenizer tokens = new StringTokenizer(line, ",");
				String val = null, key = null;
				
				// first token key and second token value
				while (tokens.hasMoreTokens())
				{
					val = tokens.nextToken().trim();
					if (!table.containsKey(key))
					{
						key = val;
						// first put the key
						table.put(key, null); 
					}
					// then look for the key and update the value
					else table.put(key, val); 
				}
			}
				
		}
	}

	/**
	 * Read the first 10 lines of the CSV file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void printFirst10Lines() throws FileNotFoundException, IOException
	{
		try(BufferedReader br = new BufferedReader(new FileReader(new File(file_name)));)
		{
			int i = 0;
			do
			{
				i++;
				System.out.println("Line " + i + ": " + br.readLine());
			}
			while ( i < 10);		
		}
	}
	
	/**
	 * Prints the table to the console
	 * @param map
	 */
	public static void dumpTable(Map<String, String> map)
	{
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		
		while (it.hasNext())
		{
			String key = it.next();
			System.out.println("Key: " + key + " Value: " + table.get(key));
		}
	}

	/**
	 * To write all the country names that starts with letter passed in countryNameBeginningWith, along with their capitals.
	 * @param countryNameBeginningWith
	 */
	public static void writeToFile(String newFilename, char countryNameBeginningWith)
	{
		// TODO
	}
	
	public static void main(String[] args)  
	{
		try 
		{
			TextFileHandler.printFirst10Lines();
			
			TextFileHandler.loadFile();
			TextFileHandler.dumpTable(TextFileHandler.getTable());
		} 
		catch (IOException e) 
		{ e.printStackTrace(); }
	}
}
