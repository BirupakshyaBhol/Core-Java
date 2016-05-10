package module2;

public class IntegerFinderTest 
{
	protected static final String BROADCAST_MSG = "Found [Number,Index] = ";
	
	public static void main(String[] args) 
	{
		int[] x = {2,3,4,5,7,6,8,9,11,1,32,45,2,67};
		IntegerFinderTest t = new IntegerFinderTest();
		
		t.integerFinder(2, x, new IntegerFinderListener() {	
			@Override
			public void found(int number, int index) 
			{ System.out.println(BROADCAST_MSG + number + "," + index); }
		});
	}

	public boolean integerFinder(int n, int[] a, IntegerFinderListener s)
	{
		for (int i = 0; i < a.length; i++)
		{
			if (n == a[i]) 
			// the implementation of found(...) is in the above anonymous inner class
			{ s.found(a[i], i); } 
		}
		return false;
	}
}

interface IntegerFinderListener
{ public void found(int number, int index); }
