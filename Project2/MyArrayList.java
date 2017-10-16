////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249
//  Section:  (your section number) 
// 
//  Project:  Project2
//  File:     MyArrayList
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

public class MyArrayList<E extends Comparable<E>> extends MyAbstractList<E>
{
	public static final int INITIAL_CAPACITY = 16;
	private E[] data = null;
	public int capacity; 

	// Create a default list of 16 elements
	public MyArrayList()
	{
		data = (E[]) new Comparable[INITIAL_CAPACITY]; // array
		capacity = INITIAL_CAPACITY;
	}

	// Create a list of capacity elements
	public MyArrayList (int capacity)
	{
		data = (E[]) new Comparable[capacity]; // array
	}

	// Create a list from an array of objects
	public MyArrayList (E[] objects)
	{
		for (int i = 0; i < objects.length; i++)
		{
			add (objects[i]); // Warning: don’t use super(objects)!
		}
	}

	// Add a new element at the specified index
	@Override
	public void add (int index, E e)
	{
		// Doubles array, if not big enough
		ensureCapacity(); 

		// Move the elements to the right after the specified index
		for (int i = size - 1; i >= index; i--)
		{
			data[i + 1] = data[i];
		}

		// Insert new element to data[index] and increase size
		data[index] = e;    
		size++;         
	}

	// Create a new larger array, double the current size + 1
	private void ensureCapacity()
	{
		if (size >= data.length)
		{
			E[] newData = (E[]) (new Comparable[size * 2 + 1]);
			System.arraycopy (data, 0, newData, 0, size);
			data = newData;
		}
	}

	// Return true if this list contains the element
	@Override
	public boolean contains (E e)
	{
		for (int i = 0; i < size; i++)
		{
			if (e.equals(data[i]))
			{
				return true;
			}
		}
		return false;
	}

	// Return the element at the specified index
	@Override
	public E get (int index)
	{
		checkIndex (index);
		return data[index];
	}

	// Throws IndexOutOfBoundsException, if needed
	private void checkIndex (int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException
			("Index: " + index + ", Size: " + size);
		}
	}

	// Return the index of the first matching element
	// Return -1 if no match.
	@Override
	public int indexOf(E e)
	{
		for (int i = 0; i < size; i++)
		{
			if (e.equals (data[i]))
			{
				return i;
			}
		}
		return -1;
	}

	// Return the index of the last matching element
	// Return -1 if no match.
	@Override
	public int lastIndexOf (E e)
	{
		for (int i = size - 1; i >= 0; i--)
		{
			if (e.equals (data[i]))
			{
				return i;
			}
		}
		return -1;
	}

	// Remove the element at the specified position
	// Shift any subsequent elements to the left.
	// Return the element that was removed from the list.
	@Override
	public E remove(int index)
	{
		checkIndex (index);
		E old = data[index];

		// Shift data to the left
		for (int j = index; j < size - 1; j++)
		{
			data[j] = data[j + 1];
		}
		data[size - 1] = null;		 // This element is now null
		size--;						  // Decrement size
		return old;
	}

	// Replace the element at the specified position
	// with the specified element.
	@Override
	public E set (int index, E e)
	{
		checkIndex (index);
		E old = data[index];
		data[index] = e;
		return old;
	}

	// Return a string representation of the array
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < size; i++)
		{
			result.append (data[i]);
			if (i < size - 1)
			{
				result.append (", ");
			}
		}
		return result.toString() + "]";
	}

	// Trims the capacity of the array to the current size
	// If size == capacity, no need to trim
	public void trimToSize()
	{
		if (size != data.length)
		{
			E[] newData = (E[]) (new Comparable[size]);
			System.arraycopy (data, 0, newData, 0, size);
			data = newData;
		}
	}

	// Clear the array: create a new empty one
	@Override
	public void clear()
	{
		data = (E[]) new Comparable[INITIAL_CAPACITY];
		size = 0;
	}

	// Override iterator() defined in Iterable
	@Override
	public java.util.Iterator<E> iterator()
	{
		return new ArrayListIterator();
	}

	// Private iterator class for myArrayList class
	private class ArrayListIterator implements java.util.Iterator<E>
	{
		private int current = 0; // Current index

		// Return true when there are more elements past current
		@Override
		public boolean hasNext()
		{
			return(current < size);
		}

		// Return the element at current
		@Override
		public E next()
		{
			return data[current++];
		}

		// Remove the element at current
		@Override
		public void remove()
		{
			MyArrayList.this.remove(current);
		}
	}
}

