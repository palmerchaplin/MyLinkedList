package assignment4;

public abstract class AbstractList<E>
{
	protected int size;

	public AbstractList()
	{
		this.size = 0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
	void checkIndex(int i)
	{
		if (i < 0 || i >= size)
		{
			//	the index is out of bounds
			throw new IndexOutOfBoundsException(i + "");
		}
	}
	
}