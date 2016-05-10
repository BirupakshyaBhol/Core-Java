package module4.asso;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class TestMap 
{
	public static void main(String[] args) 
	{
		Hashtable<String, String> countries = new Hashtable<String, String>();

		// Hashtable.put(key=country, value=capital) 
		countries.put("India", "New Delhi");
		countries.put("Nepal", "Kathmandu");
		countries.put("Bhutan", "Thimpu");
		countries.put("Pakistan", "Islamabad");
		countries.put("Sri Lanka", "Colombo");

		// Hashtable.get(key) method is used to retrieve values from the Hashtable
		System.out.println(">>> Capital of India: " + countries.get("India"));

		// Use Hashtable.containsKey(Object) method to check if an key in the Hashtable
		System.out.println(">>> Does hashtable contain Pakistan as key: "
				+ countries.containsKey("Pakistan"));

		// Hashtable.containsValue(Object) returns true if Hashtable contains the specified value
		System.out.println(">>> Does hashtable contain Thimpu as value: "
				+ countries.containsValue("Thimpu"));


		// Hashtable.elements() return enumeration of all Hashtable values
		System.out.println(">>> Hashtable values:");
		Enumeration<String> enumeration = countries.elements();
		while (enumeration.hasMoreElements()) 
			System.out.println(enumeration.nextElement());

		// Hashtable.isEmpty() to check emptiness of Hashtable 
		System.out.println(">>> Is hashtable empty: " + countries.isEmpty());
		// Hashtable.size() method to find size of hashtable in Java
		System.out.println(">>> Size of hashtable: " + countries.size());

		System.out.println(">>> The >inefficient< way to traverse a map...");
		Set<String> keySet = countries.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext())
		{
			String key = it.next();
			System.out.println(key + ", " + countries.get(key));
		}
		
		System.out.println(">>> The most *efficient* way to traverse a map...");
		Set<Entry<String, String>> entries = countries.entrySet();
		for (Entry<String, String> entry : entries)
			System.out.println(entry.getKey() + ", " + entry.getValue());
		
		// Hashtable.clear() clears all mappings, we can reuse an existing hashtable.
		countries.clear();
		System.out.println(">>> Size of hashtable after clearing: " + countries.size());
	}
}
