package module2;

public class Annonymous
{
	public static void main(String[] args)
	{
		Test t = new Test()
		{
			@Override
			public void testMethod()
			{
				System.out.println(">>> testMethod()");;
			}
		};
		
		t.testMethod();
	}
}

interface Test
{
	public void testMethod();
}