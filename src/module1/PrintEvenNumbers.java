package module1;

public class PrintEvenNumbers {

	public static void main(String[] args) {
		int [] evenNumbers = {110,112,234,335,487,555,16,73,18,99};
		
		for (int i = 0; i < evenNumbers.length; i++)
		{
			if (evenNumbers[i]%2 == 0)
			{
				System.out.println("Found even number:" + evenNumbers[i] 
						+ " at index=" + i);
			}
		}
	}
}
