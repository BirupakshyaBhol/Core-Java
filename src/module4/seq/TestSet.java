package module4.seq;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public final class TestSet 
{
	public static void main(String[] args) 
	{
		TreeSet<Integer> tree_set = new TreeSet<Integer>();
		int i;
		// Adding data to the list
		for (i = 0; i < 5; i++ )
			tree_set.add(new Integer((int)(Math.random()*100)));

		// Printing data from the list
		System.out.println(">>> TreeSet Elements:");
		Iterator<Integer> it = tree_set.iterator();
		while (it.hasNext())
			System.out.println(it.next());

		HashSet<Integer> hash_set = new HashSet<Integer>();
		// Adding data to the list
		for (i = 0; i < 5; i++ )
			hash_set.add(new Integer((int)(Math.random()*100)));

		// Printing data from the list
		System.out.println(">>> HashSet Elements:");
		it = hash_set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
