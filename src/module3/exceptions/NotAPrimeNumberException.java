package module3.exceptions;

@SuppressWarnings("serial")
public class NotAPrimeNumberException extends Exception 
{
	public NotAPrimeNumberException(String message)
	{ super(message); }

	public NotAPrimeNumberException(String message, Throwable cause)
	{ super(message, cause); }

	@Override
	public String getMessage()
	{ return super.getMessage(); }
	
	@Override
	public String toString()
	{ return super.toString(); }
}
