package assignment4;

import java.util.Iterator;

/**
 *
 * @author graham
 */
//	E is the type of the elements of the list
public class ArrayList<E> extends AbstractList<E> implements IFiniteList<E>, Iterable<E>
{
	private final static int DEFAULT_INITIAL_SIZE = 4;

	private E[] theArray;

	public ArrayList(int initialSize)
	{
		super();
		this.theArray = (E[]) new Object[ initialSize ];
	}

	public ArrayList()
	{
		this(DEFAULT_INITIAL_SIZE);
	}

	//	insert d into an array a with count elements in it
	//	i.e. the first count elements of a, are the actual elements
	//	so count <= a.length - 1
	public void add(E d)
	{
		if (this.theArray.length == this.size)
		{
			//	make a new array 1 bigger than the old array
			E[] newNumbers = (E[]) new Object[ this.theArray.length * 2 ];
			//	copy the old array into the new array
			for (int i = 0; i < this.theArray.length; i++)
			{
				newNumbers[i] = this.theArray[i];
			}
			this.theArray = newNumbers;
		}

		this.theArray[this.size] = d;
		this.size++;
	}

	//	get the i-th element of the array
	public E get(int i)
	{
		checkIndex(i);
		return this.theArray[i];
	}

	public void delete(int i)
	{
		checkIndex(i);
		for (int j = i; j < this.size - 1; j++)
		{
			this.theArray[j] = this.theArray[j + 1];
		}

		this.theArray[this.size - 1] = null;
		this.size--;
	}

	@Override
	public Iterator<E> iterator()
	{
		return new ArrayListIterator<>(this);
	}
}