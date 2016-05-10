package module4.generics;

/**
 * Generic class for key-value pairs.
 * @author pbose
 *
 * @param <K>
 * @param <V>
 */
public class KeyValuePair <K, V>
{
	protected K key;
	protected V value;
	
	public KeyValuePair(K key, V value) 
	{
		this.key = key;
		this.value = value;
	}

	public K getKey()	{ return key; }
	public V getValue() { return value; }
	
	public String toString()
	{ return "(" + key + ", " + value + ")"; }
	
	public static void main(String[] args) 
	{
		KeyValuePair<Integer, String> p1 = 
				new KeyValuePair<Integer, String>(new Integer(1), "One");
		
		System.out.println(p1.toString());

		KeyValuePair<Integer, Double> p2 = 
				new KeyValuePair<Integer, Double>(new Integer(1), Math.PI);
		
		System.out.println(p2.toString());
	}
}
