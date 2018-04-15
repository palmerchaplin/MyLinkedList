/*
 * Copyright OrangeDog LLC.
 * All rights reserved.
 */
package assignment4;

import java.util.Iterator;

/**
 *
 * @author graham
 */
public class ArrayListIterator<E> implements Iterator<E>
{
	private int i;
	private ArrayList<E> theList;

	public ArrayListIterator(ArrayList<E> theList)
	{
		this.theList = theList;
		this.i = 0;
	}
	
	public boolean hasNext()
	{
		return i < this.theList.size();
	}

	public E next()
	{
		E result = this.theList.get(this.i);
		this.i++;
		return result;
	}
}