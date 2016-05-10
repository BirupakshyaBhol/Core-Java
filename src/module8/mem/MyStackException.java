package module8.mem;

@SuppressWarnings("serial")
public class MyStackException extends Exception 
{
	public MyStackException(String message)
	{ super(message); }

	public MyStackException(String message, Throwable cause)
	{ super(message, cause); }

	@Override
	public String getMessage()
	{ return super.getMessage(); }
	
	@Override
	public String toString()
	{ return super.toString(); }
}
