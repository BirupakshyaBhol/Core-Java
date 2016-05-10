package module4.generics;

import java.util.Collections;
import java.util.Vector;

public final class BinarySearchTest 
{
	public static void main(String[] args) 
	{
		Vector<Integer> num_list = new Vector<Integer>();
		int i;
		// Adding data to the list
		for (i = 0; i < 50; i++ )
			num_list.add(new Integer((int)(Math.random()*100)));
		
		int ret_val = Collections.binarySearch(num_list, new Integer(74));
		if (ret_val < 0)
			System.out.println("Item not found...");
		else System.out.println("Item found...");		
	}
}
