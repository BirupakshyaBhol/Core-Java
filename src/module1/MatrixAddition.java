package module1;

public class MatrixAddition {

	public static void main(String[] args) {
		int i,j;
		int [][] 
				matrix_1 = {{1,2,3}, {4,5,6}, {7,8,9}}, 
				matrix_2 = {{9,8,7}, {6,5,4}, {3,2,1}};
		
		int [][] result = new int[3][3];

		for (i = 0; i < matrix_1.length; i++)
		{
			for (j = 0; j < matrix_1[i].length; j++)
			{
				result[i][j] = matrix_1[i][j] * matrix_2[i][j];
			}
		}
		
		// print result
		for (i = 0; i < result.length; i++)
		{
			for (j = 0; j < result[i].length; j++)
			{
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
