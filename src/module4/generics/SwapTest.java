package module4.generics;

import java.util.Arrays;

public class SwapTest 
{
	/* Generic method to swap positions in array */
	public static <T> T[] swap(T [] list, int firstPos, int secondPos) 
			throws ArrayIndexOutOfBoundsException
	{
		if (firstPos >= 0 && firstPos < list.length && secondPos >= 0 && secondPos < list.length)
		{
			T temp = list[firstPos];
			list[firstPos] = list[secondPos];
			list[secondPos] = temp;
			
			return list;
		}
		else throw new ArrayIndexOutOfBoundsException("Out of bounds indexes.");
	}

	public static void main(String[] args) 
	{
		/* Test for swap */
		Integer [] i = {1,2,3,4,5,6};
		System.out.println("After swap: " + 
					Arrays.toString(SwapTest.swap(i, 0, i.length-1)));
		
		/* Test for swap */
		String [] s = {"Raspberry", "Blueberry", "Cranberry", "Strawberry"};
		System.out.println("After swap: " + 
					Arrays.toString(SwapTest.swap(s, 2, s.length-1)));
	}
}
