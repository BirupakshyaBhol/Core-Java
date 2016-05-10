package module4.generics;

import java.util.List;
import java.util.Vector;

/**
 * Supports arithmetic operations of +, -, *, / on any type that are subclasses 
 * of {@link java.lang.Number}.
 * @author pbose
 *
 */
public class ArithmeticOperations
{	
	/**
	 * Generic method to add 2 numbers.
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T extends Number> Number add(T t1, T t2)
	{ return (t1.doubleValue() + t2.doubleValue()); }

	/**
	 * Demostrates Upper Bounded Wildcards.
	 * Generic method to add numbers from a list.
	 * @param list
	 * @return
	 */
	public static Number add(List<? extends Number> list)
	{
		double d = 0;
		for (Number n : list)
			d += n.doubleValue(); 
		
		return new Double(d);
	}
	
	/**
	 * Demostrates Upper Bounded Wildcards with a different approach.
	 * Here 'T' can be accessed as any object.
	 * Generic method to add numbers from a list.
	 * @param list
	 * @return
	 */
	public static <T extends Number> Number add1(List<T> list)
	{
		double d = 0;
		for (T t : list)
			d += t.doubleValue(); 
		
		return new Double(d);
	}

	/**
	 * Demostrates Unbounded Wildcards.
	 * Generic method to dump list data to console.
	 * @param list
	 * @return
	 */
	public static void dumpList(List<?> list)
	{
		System.out.println("List dump with unbounded wildcard:");
		for (Object o : list)
			System.out.println(o);
	}

	public static void main(String[] args) 
	{
		// Adding 2 integers
		Integer i1 = new Integer(34), i2 = new Integer(43);
		System.out.println("Add with generic method: " + ArithmeticOperations.add(i1, i2));
		Float f1 = new Float(12.56), f2 = new Float(3.6778);
		System.out.println("Add with generic method: " + ArithmeticOperations.add(f1, f2));

		// Adding 2 integers through a list
		Vector<Number> l = new Vector<Number>();
		l.add(new Integer(34));
		l.add(new Integer(43));
		System.out.println("Add with upper bounded wildcard: " + ArithmeticOperations.add(l));		
		
		// Dumping the list to the console.
		ArithmeticOperations.dumpList(l);
	}
}
