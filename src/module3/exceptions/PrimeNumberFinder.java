package module3.exceptions;

public final class PrimeNumberFinder 
{
	public static void verifyPrimes(int [] prime_list) 
			throws NotAPrimeNumberException
	{
		for (int i = 0; i < prime_list.length; i++)
		{
			if (!isPrime(prime_list[i]))
				throw new  NotAPrimeNumberException(prime_list[i] 
						+ " at index=" + i + " is not a prime number");
		}
	}
	
	private static boolean isPrime(int n)
	{
		for(int i= 2; i <= n/2; i++)
	        if(n % i == 0) return false;
    	
        return true;
	}

	public static void main(String[] args) 
	{
		try
		{
			int [] prime_list = {11, 13, 17, 20, 23, 29, 31, 37, 
					41, 43, 47, 53, 59, 61, 67};
			
			PrimeNumberFinder.verifyPrimes(prime_list);
			System.out.println("Verified.");
			
		}
		catch(NotAPrimeNumberException np)
		{ np.printStackTrace(); }
		catch(Exception e)
		{ e.printStackTrace(); }
	}
}
