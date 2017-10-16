////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number) 
// 
//  Project:  Project2
//  File:     HuffTree
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

public class HuffTree implements Comparable<HuffTree>
{
    private HuffNode root;

    /**
     * Create a default binary tree
     */
    public HuffTree()
    {
	root = null;
    }

    /**
     * Create a tree with two subtrees
     */
    public HuffTree (HuffTree t1, HuffTree t2)
    {
        // add code
    }

    /**
     * Create a tree containing a leaf node
     */
    public HuffTree (HuffElement element)
    {
	// add code
    }

    /**
     * Returns the root of the tree
     */
    public HuffNode getRoot()
    {
	// add code       
    }

    /**
     * Compare the roots of the HuffTrees
     */
    @Override
    public int compareTo (HuffTree ht)
    {
	// add code
    }

    // Inner class HuffNode whose element is a HuffElement

    public static class HuffNode implements Comparable<HuffNode>
    {
        protected HuffElement element;
        public HuffNode left;
        public HuffNode right;

        /**
         * Create a node with passed in element
         */
        public HuffNode (HuffElement elem)
        {
	    // add code
        }

        /**
         * Return the element character
         */
        public char getChar()
        {
            // add code
        }

        /**
         * Return the element character count
         */
        public int getCount()
        {
            // add code
        }

        /**
         * Set the element character count
         */
        public void setCount (int count)
        {
            // add code
        }

        /**
         * Return the element character binary code
         */
        public String getCode()
        {
            // add code
        }

        /**
         * Set the element character binary code
         */
        public void setCode (String str)
        {
            // add code
        }

        /**
         * Compare the nodes by comparing the elements
         */
        @Override
        public int compareTo (HuffNode node)
        {
            // add code
        }

        /**
         * Return node as a String using the element
         */
        @Override
        public String toString()
        {
            // add code
        }
    }
}








