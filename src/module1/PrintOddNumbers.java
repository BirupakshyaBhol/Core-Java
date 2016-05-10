package module1;

public class PrintOddNumbers {

	public static void main(String[] args) {
		int [][] oddNumbers = {
								{111,112,234},
								{335,487,555}, 
								{16,73,99} 
								};
		int i, j;
		
		for (i = 0; i < oddNumbers.length; i++)
		{
			for (j = 0; j < oddNumbers[i].length; j++)
			if (oddNumbers[i][j]%2 != 0)
			{
				System.out.println("Found odd number:" + oddNumbers[i][j] 
						+ " at [i,j]=[" + i + "," + j + "]");
			}
		}
	}
}
