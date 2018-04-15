package assignment4;

/**
 *	A list is an ordered collection that you can add to, and get from
 */
public interface IList<E>
{
	public void add(E element);
	
	public E get(int i);
	
	public void delete(int i);
}