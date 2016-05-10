package module8.mem.leaks;

import java.util.Iterator;
import java.util.NoSuchElementException;

import module8.mem.MyStackException;

public class MyStack<E> implements Iterable<E>
{
	protected E[] data = null;
	protected int stack_pointer = 0;
	
	@SuppressWarnings("unchecked")
	public MyStack(int capacity)
	{ data = (E[]) new Object[capacity]; }
	
	public void push(E element) throws MyStackException
	{
		if (stack_pointer == data.length)
			throw new MyStackException("Stack overflow.");
		data[stack_pointer++] = element;
	}
	
	public boolean isEmpty()
	{ return stack_pointer == 0; }
	
	public int size()
	{ return stack_pointer; }

	public E pop() throws MyStackException
	{
		if (stack_pointer == 0)
			throw new MyStackException("Stack underflow.");
		return data[--stack_pointer];
	}
	
	@Override
	public Iterator<E> iterator() 
	{		
		return new Iterator<E>()
		{
			private int i = 0;
			
			@Override
			public E next()
			{
				if (i > stack_pointer - 1)
					throw new NoSuchElementException("No element to retrieve.");
				return data[i++];
			}

			@Override
			public void remove() 
			{ throw new UnsupportedOperationException("Operation not supported."); }

			@Override
			public boolean hasNext() 
			{ return i < stack_pointer; }
		};
	}
}
