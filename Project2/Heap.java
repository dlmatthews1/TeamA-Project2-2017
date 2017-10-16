////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number)
// 
//  Project:  Project2
//  File:     Heap
//  
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

public class Heap<E extends Comparable<E>>
{
    private MyArrayList<E> list = new MyArrayList<E>();

    /**
     * Create a default heap
     */
    public Heap()
    {
    }

    /**
     * Create a heap from an array of objects
     */
    public Heap (E[] objects)
    {
        for (int i = 0; i < objects.length; i++)
        {
            add (objects[i]);
        }
    }

    /**
     * Add a new object into the heap
     */
    public void add (E newObject)
    {
        list.add (newObject); // Append to the heap
        int currentInd = list.size() - 1; // last node

        while (currentInd > 0)
        {
            int parentInd = (currentInd - 1) / 2;

            if (list.get (currentInd).compareTo (list.get(parentInd)) < 0)
            {
                // Swap when current < parent
                E temp = list.get (currentInd);
                list.set (currentInd, list.get (parentInd));
                list.set (parentInd, temp);
            }
            else
            {
                break; // the tree is a heap now
            }

            currentInd = parentInd;
        }
    }

    /**
     * Remove the root from the heap
     */
    public E remove()
    {
        if (list.size() == 0)
        {
            return null;
        }

        // Get root
        E removedObject = list.get (0);
        // Update root element with last element info in Heap array
        list.set (0, list.get (list.size() - 1));
        // Remove last array elemnt
        list.remove (list.size() - 1);

        // Walk tree to reheapify it
        int currentInd = 0;
        while (currentInd < list.size())
        {
            int ltChildInd = 2 * currentInd + 1;
            int rtChildInd = 2 * currentInd + 2;

            if (ltChildInd >= list.size())
            {
                break;
            }

            int minInd = ltChildInd;
            if (rtChildInd < list.size())
            {
                // Make rightChild the current minimum when less
                if (list.get (minInd).compareTo (list.get (rtChildInd)) > 0)
                {
                    minInd = rtChildInd;
                }
            }

            // Swap if current > minimum
            if (list.get (currentInd).compareTo (list.get (minInd)) > 0)
            {
                E temp = list.get (minInd);
                list.set (minInd, list.get (currentInd));
                list.set (currentInd, temp);
                currentInd = minInd;
            }
            else
            {
                break; // The tree is a heap
            }
        }
        return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize()
    {
        return list.size();
    }
}





