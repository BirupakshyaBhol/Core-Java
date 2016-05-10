package module4.generics;

/**
 * Generic search method.
 * @author pbose
 *
 */
public final class GenericSearchTest 
{
	/* Generic method to search an element in the list */
	public static <T> boolean search(T [] list, T itemToSearch)
	{
		for (T listItem : list)
		{
			if (listItem == itemToSearch)
				return true;
		}
		return false;
	}

	public static void main(String[] args) 
	{
		/* Test for search */
		Integer [] i = {1,2,3,4,5,6};
		System.out.println("Found: " + GenericSearchTest.search(i, 3));
		System.out.println("Found: " + GenericSearchTest.search(i, 30));

		String [] s = {"Raspberry", "Blueberry", "Cranberry", "Strawberry"};
		System.out.println("Found: " + GenericSearchTest.search(s, "Blueberry"));
		System.out.println("Found: " + GenericSearchTest.search(s, "Gooseberry"));
	}
}
