package module2;

public abstract class AbstractSearch 
{
	public abstract boolean search(Object [] obj_list, Object obj);
	
	public boolean isEqual(Integer x, Integer y)
	{ return (x.intValue() == y.intValue()); }

	public static void main(String[] args)
	{
		IntegerSearch i = new IntegerSearch();
		Integer[] s = {new Integer(2),new Integer(3),new Integer(4)};
		Integer f = new Integer(4);
		
		
		System.out.println(i.search(s, f));
		
		System.out.println(i.isEqual(new Integer(2),new Integer(3)));
	}
}

class IntegerSearch extends AbstractSearch
{
	@Override
	public boolean search(Object[] obj_list, Object obj) 
	{
		for (int i = 0; i < obj_list.length; i++)
		{
			if (((Integer)obj_list[i]).intValue() == ((Integer)obj).intValue())
				return true;
		}
		return false;
	}
}
