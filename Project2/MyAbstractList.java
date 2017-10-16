////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249
//  Section:  (your section number) 
// 
//  Project:  Project2
//  File:     MyAbstractList
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

public abstract class MyAbstractList<E extends Comparable<E>> implements MyList<E>
{
    protected int size = 0; // The size of the list

    protected MyAbstractList()
    {
    } // Create a default list

    // Create a list from an array of objects
    protected MyAbstractList (E[] objects)
    {
        for (int i = 0; i < objects.length; i++)
        {
            add (objects[i]);
        }
    }

    // Add a new element at the end of this list
    @Override
    public void add (E e)
    {
        add (size, e);
    }

    // Return true if this list contains no elements
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Return the number of elements in this list
    @Override
    public int size()
    {
        return size;
    }

    // Remove the first occurrence of the element e
    // Shift any subsequent elements to the left.
    // Return true if the element is removed.
    @Override
    public boolean remove (E e)
    {
        if (indexOf (e) >= 0)
        {
            remove (indexOf(e));
            return true;
        }
        else
        {
            return false;
        }
    }
}


