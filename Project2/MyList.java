////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249
//  Section:  (your section number) 
// 
//  Project:  Project2
//  File:     MyList
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

public interface MyList<E extends Comparable<E>> extends java.lang.Iterable<E>
{
    // Add a new element at the end of this list
    public void add (E e);

    // Add a new element at specified index in this list
    public void add (int index, E e);

    // Return true if this list contains the element
    public boolean contains (E e);

    // Return the element at the specified index
    public E get (int index);

    // Return the index of the first matching element
    // Return -1 if no match.
    public int indexOf (E e);

    // Return the index of the last matching element
    // Return -1 if no match.
    public int lastIndexOf (E e);

    // Return true if this list contains no elements
    public boolean isEmpty();

    // Clear the list
    public void clear();

    // Remove the first occurrence of the element
    // Shift any subsequent elements to the left.
    // Return true if the element is removed.
    public boolean remove (E e);

    // Remove the element at the specified position
    // Shift any subsequent elements to the left.
    // Return the element that was removed from the list.
    public E remove (int index);

    // Replace the element at the specified position
    // with the specified element and returns the new set.
    public Object set (int index, E e);

    // Return the number of elements in this list
    public int size();
}

