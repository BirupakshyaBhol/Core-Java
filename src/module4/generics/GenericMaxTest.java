package module4.generics;

/**
 * Generic max method.
 * @author pbose
 *
 */
public final class GenericMaxTest
{
	public static <T extends Comparable<T>> T max(T [] array)
	{
		T max = array[0];
		
		for (T t : array)
		{
			if (t.compareTo(max) > 0)
				max = t;
		}
		
		return max;
	}
	
	public static void main(String[] args)
	{
		Integer [] i = {new Integer(3), new Integer(5), new Integer(4)};
		
		System.out.println(max(i));
		
		Float [] f = {new Float(3.56), new Float(0.98), new Float(3.84)};
		
		System.out.println(max(f));
	}
}
