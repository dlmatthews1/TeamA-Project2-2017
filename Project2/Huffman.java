////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number) 
// 
//  Project:  Project2
//  File:     Huffman
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Huffman
{
    private MyMap<FileChar, HuffElement> huffMap = null;
    private final char EOF = 0x7F;

    /**
     * Construct a Huffman object to compress and decompress a text string
     * Instantiate the MyHashMap huffMap 
     */
    public Huffman (int numASCIIchars)
    {
	// add code
    }

    /**
     * Populate the huffMap with the FileChar and HuffElement entries
     * Used to hold the file characters and their frequency counts
     * Loop through the fileStr, create FileChar and HuffElement objects
     * from each character in the string and add them to huffMap or
     * increment the count in huffMap, if the character is already there
     */
    public void buildCountMap (String fileStr)
    {
        huffMap.clear();

        // add loop code
	      
    }

    /**
     * Get a Huffman tree from the counts in huffMap
     * Build forest of HuffTrees from huffMap and add to Min Heap
     * Loop through the Heap removing the two minimum trees, 
     * combine them into a single tree and add it back to Heap
     * Return the final tree: Last tree in heap
     */
    public HuffTree buildHuffmanTree()
    {
        // Build forest of HuffTrees from huffMap
	    
	// Create the heap
        
	// add code

	// Retrieve the set of keys
	
	// add code

	// Loop through the set of keys (use for each loop):
	// Use the key to get the HuffElement
	// Create a HuffTree with a single node from the HuffElement
        // Add the HuffTree to the Heap
        
	// add code

        // Loop through Heap, removing two lowest count tree
	// Create a new HuffTree using these two trees
	// Add new tree to the Heap

	// add code

        // Return the final tree: Last tree in heap
        
	// add code
    }

    /**
     * Get the Huffman codes for the characters in huffMap 
     * Check for root == null and return if so
     * Call assignCode
     */
    public void getHuffmanCodes (HuffTree.HuffNode root)
    {
        // add code

    }

    /**
     * Recursively get codes to the leaf node
     */
    private void assignCode (HuffTree.HuffNode root)
    {
        // add code
    }

    /**
     * Builds a new string of ones and zeros by walking through the fileStr
     * string and replacing each character with the code in the HuffElement
     * which is gotten from the huffMap using a FileChar built from the char
     */
    public String buildBinaryString (String fileStr)
    {
	// add code

        return bitStr;
    }

    /**
     * Compress:
     * Take the incoming file converted into a String and add EOF marker
     * Build the character frequency count HashMap
     * Build a Huffman tree 
     * Get the Huffman code for each character by traversing the tree
     * Use the codes to produce a binary string from the file
     * Return the binary string for output
     */
    public String compress (String fileStr)
    {
        // Add a EOF marker (use ASCII 127)
        
	// add code

        // Build the huffMap to hold the char counts and codes
        
	// add code

        // Build Huffman tree
        
	// add code

        // Generate Huffman codes
        
	// add code

        // Produce a binary string from the file usung the codes
	
	// add code

	// Return the binary string
        return binStr;
    }

    /**
     * Decompress:
     * Rebuild the Huffman tree from the MyHashMap
     * Loop through each character (0 or 1) in the binaryStr) 
     *    Traverse the tree going left with '0' and right with '1'
     *    When you find a leaf node add its char to the output string.
     *    Check each leaf for EOF char and break when found
     * Return the decompressed string
     */
    public String decompress (String binaryStr)
    {
        // Rebuild tree
        
	// add code

        // String for decompressed text
        
	// add code

        // Use currentNode to walk the tree using each the binary string
        // to convert the ones and zeros back to their character
        
        
	// add code

        // Walk the Huffman tree to the leaves
	    
	    // Go left if character is '0'
	    // Go right if character is '1'
            
	    // add code

            // If leaf, grab the character and add it to the string
	    // If the character is EOF, then break to end 
	    // Restart at the root for the next letter
	    
	    // add code
        
        return decompStr;
    }
}
