package module2;

public class Parent
{
	protected int x = 0;

	// Default parent class constructor
	public Parent()
	{ 
		System.out.println("Parent.Parent(): x = " + x); 
	}

	// One parameter parent class constructor
	public Parent(int x)
	{ 
		this.x = x;
		{ System.out.println("Parent.Parent(): x = " + x); }
	}

	public static void main(String[] args)
	{
		Child tc1 = new Child(), tc2 = new Child(2);
	}
}

class Child extends Parent
{
	// Default child class constructor
	public Child()
	{
		System.out.println("Child.Child(): x = " + x);
	}
	
	// One parameter child class constructor
	public Child(int x)
	{ 
		super(x); // calling the one parameter child base class constructor first
		System.out.println("Child.Child(): x = " + x);
	}
}