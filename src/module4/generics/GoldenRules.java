package module4.generics;

import java.util.List;
import java.util.Vector;

/**
 * Demostrating the golden rules of wildcards.
 * @author pbose
 *
 */
public final class GoldenRules 
{
	/**
	 * Extracting the even numbers from one list and putting it into another list.
	 * @param input This is the input list with upper bounded wildcards
	 * @param output This is the output list with lower bounded wildcards
	 */
	public static void extractEvenInteger(List<? extends Integer> input, List<? super Integer> output)
	{
		for (Integer i : input)
		{
			if (i%2 == 0)
				output.add(i);
		}
	}
	
	/**
	 * Generic method to dump list data to console.
	 * @param list This is using unbounded wildcard where the parameter is both in & out.
	 * @return
	 */
	public static void dumpList(List<?> list)
	{
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	public static void main(String[] args) 
	{
		Vector<Integer> list = new Vector<Integer>(), 
				extractedList = new Vector<Integer>();
		int i;
		
		// Creating an integer list
		for (i = 0; i < 5; i++ )
			list.add(new Integer((int)(Math.random()*100)));
		
		// Extracting the even integers
		GoldenRules.extractEvenInteger(list, extractedList);
		// Printing the even integers
		GoldenRules.dumpList(extractedList);
	}
}
