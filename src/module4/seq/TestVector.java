package module4.seq;

import java.util.Vector;

public final class TestVector 
{
	public static void main(String[] args) 
	{
		Vector<Integer> list = new Vector<Integer>();
		int i;
		// Adding data to the list
		for (i = 0; i < 5; i++ )
			list.add(new Integer(i+1));

		// Printing data from the list
		System.out.println("Vector Elements:");
		for (i = 0; i < list.size(); i++ )
			System.out.println(list.get(i));
		
		// Random access of elements, method throws ArrayIndexOutOfBoundsException
		System.out.println("Vector Element[3] = " + list.elementAt(3));
		
		// Insertion of elements, method throws ArrayIndexOutOfBoundsException
		list.insertElementAt(new Integer(40), 3);
		System.out.println("Vector Element[3] = " + list.elementAt(3));

		// Printing data from the list
		System.out.println("New Vector Elements:");
		for (i = 0; i < list.size(); i++ )
			System.out.println(list.get(i));
	}
}
