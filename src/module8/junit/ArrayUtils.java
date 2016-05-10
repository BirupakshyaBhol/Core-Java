package module8.junit;

public final class ArrayUtils 
{
	/**
	 * Dividing the first integer array with the second and storing the result in 
	 * a float array.
	 * If the array sizes are different then {@link ArrayDataException} is thrown.
	 * This class demonstrates nested exceptions.
	 */
	public static float [] addArrays(int[] array1, int[] array2) throws ArrayDataException
	{
		float [] result = null;
		try
		{
			if (array1 == null || array2 == null)
				throw new NullPointerException("Arguments cannot be null.");
			
			if (array1.length != array2.length)
				throw new ArrayDataException("For dividing arrays, they should be of the same size.");
			
			result = new float[array1.length]; // Allocate memory only on success
				
			for (int i = 0; i < array1.length; i++)
				result[i] = (float)array1[i]/array2[i];
			
			return result;
		}
		catch(Exception e) // For all exceptions, control will come here.
		{ throw e; }
	}
}
