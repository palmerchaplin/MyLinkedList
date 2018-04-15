package assignment4;

import java.util.Iterator;

import assignment4.ListNode;

public class MyLinkedListIterator<E> implements Iterator<E> {
	
	private ListNode<E> hop;
	private MyLinkedList<E> theList;

	public MyLinkedListIterator(MyLinkedList<E> theList)
	{
		this.theList = theList;
		this.hop = theList.head;
	}
	
	public boolean hasNext()
	{
		return hop != null;
	}

	public E next()
	{
		E result = (E)this.hop.value;
		hop = hop.next;
		
		return result;
	}
}
