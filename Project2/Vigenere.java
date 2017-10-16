////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249
//  Section:  (your section number) 
// 
//  Project:  Project2
//  File:     Vigenere
//
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

/**
 * Class used to encrypt and decrypt a text string using Vigenere square
 */
public class Vigenere
{
	private int numChars;
	private char[][] vigSquare;
	private String key;

	/**
	 *  Constructor a Vigenere object and create the square
	 */
	public Vigenere (int numChs, String akey)
	{
		// add code
	}

	/**
	 *  Create the Vigenere square matrix
	 */
	private void createVigSquare()
	{
		// add code
	}

	/**
	 *  Using the key, encode the message and return the encoded message
	 */
	public String encrypt (String message)
	{
		// add code
	}

	/**
	 * Return the column index of the character, ch, in the message to be encoded
	 */
	private int getColIndex (char ch)
	{
		// add code
	}
	/**
	 * Return the row index of the key character in the Vigenere square
	 */
	private int getRowIndex (char keyCh)
	{
		// add code
	}

	/**
	 * Decrypt the plaintext string using the key and vigSquare
	 * The key characters are the 'row' index and the ciphertext
	 * characters are in the matrix at vigSquare[row][column]
	 * The plaintext characters are the column index
	 */
	public String decrypt (String text)
	{
		// add code
	}

	/**
	 * Returns the plaintext character corresponding to the ciphertext
	 * character 'ch' located in the vigSquare[rowIndex][colIndex]
	 */
	private char getPlainTextChar (int rowIndex, char ch)
	{
		// add code
	}
}

