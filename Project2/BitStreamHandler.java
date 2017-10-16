////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number) 
// 
//  Project:  Project2
//  File:     BitStreamHandler
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
//////////////////////////////////////////////////////////////////////////////////

import java.io.*;

/**
 *  Borrowed from StackOverflow ...
 */
public class BitStreamHandler
{
	private byte nthBit = 0;
	private int index = 0;
	private byte[] data;

	private FileInputStream f;

	// The buffer
	private int bits; 

	// The mask will start with 10000000 and
	// be right-shifted to read the stream from left to right
	private int mask;

	/**
	 * Construct a BitStreamHandler with the number of bits in the file
	 */
	public BitStreamHandler (int nBits) 
	{
		this.data = new byte[(int) Math.ceil(nBits / 8.0)];
	}

	/**
	 * Retrieves the current byte from the data buffer
	 * Uses a mask to set the current bit in the buffer  
	 */
	public void writeBit (boolean bit)
	{
		if (nthBit >= 8)
		{
			nthBit = 0;
			index++;
		}
		byte b = data[index];

		int mask = (1 << (7 - nthBit));

		if (bit)
		{
			b = (byte)(b | mask);
		}
		data[index] = b;
		nthBit++;
	}

	/**
	 * Creates a byte array from internal byte buffer
	 */   
	public byte[] toArray()
	{
		byte[] ret = new byte[data.length];
		System.arraycopy(data, 0, ret, 0, data.length);
		return ret;
	}

	/**
	 * Converts string to a bit stream and 
	 * Writes the bit stream to a file
	 */   
	public void writeStreamToFile(String stream, String fileName) throws Exception
	{
		for (int i = 0; i < stream.length(); i++)
		{
			writeBit (stream.charAt (i) == '1');
		}
		byte[] b = toArray();

		// write to file
		FileOutputStream fileWriter = new FileOutputStream (fileName);
		for (byte a : b)
		{
			fileWriter.write (a);
		}

		fileWriter.close();
	}

	/**
	 * Reads the binary file into a string of ones and zeros 
	 * representing the compressed file
	 */
	public String readBits (String fileName) throws Exception
	{
		f = new FileInputStream (fileName);
		bits = 0;
		mask = 0;
		String str = "";
		while (true)
		{
			if (mask == 0)
			{
				bits = f.read();
				mask = 0x80;
				if (bits==-1)
				{
					break;
				}
			}

			if ((bits & mask) == 0)
			{
				str += "0";
			}
			else
			{
				str += "1";
			}
			mask = mask >> 1;
		}

		f.close();
		return str;
	}
}