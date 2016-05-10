package module1;

// do-while is the ideal for this before it exit controlled
public class DoWhileDemo {

	private static final int NUMBERS_TO_PRINT = 20;
	
	public static void main(String[] args) {
		int i= 0;
		do
		{
			i++;
			System.out.println(i);
		}while (i < NUMBERS_TO_PRINT);
	}
}
