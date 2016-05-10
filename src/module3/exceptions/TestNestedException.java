package module3.exceptions;

public final class TestNestedException
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println(42 / 3);

			// nested try-catch
			try
			{
				System.out.println(20 / 2);
			}
			catch (ArithmeticException e)
			{
				System.out.println("Division by zero occurred in inner try-catch.");
			}
		}
		catch (ArithmeticException e)
		{
			System.out.println("Division by zero occurred in outer try-catch.");
		}
	}
}
