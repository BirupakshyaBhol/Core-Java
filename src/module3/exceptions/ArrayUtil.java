package module3.exceptions;

public final class ArrayUtil 
{
	/**
	 * Dividing the first integer array with the second and storing the result in 
	 * a float array.
	 * If the array sizes are different then {@link ArrayDataException} is thrown.
	 * This class demonstrates nested exceptions.
	 */
	public static float [] divideArrays(int[] array1, int[] array2) throws ArrayDataException
	{
		float [] result = null;
		try
		{
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
	
	public static void main(String[] args) 
	{
		int [] array1 = {2, 3, 4, 5, 6},
			   array2 = {3, 6, 7, 9, 9};
			
		try 
		{
			float [] result = ArrayUtil.divideArrays(array1, array2);

			for (int i = 0; i < result.length; i++)
				System.out.println(result[i]);
		} 
		catch (ArrayDataException e) 
		{
			e.printStackTrace();
		}
	}
}
