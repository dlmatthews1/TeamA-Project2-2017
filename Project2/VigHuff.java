
////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number)
// 
//  Project:  Project2
//  File:     VigHuff
//  
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.Scanner;

public class VigHuff
{
    private static final String INPUT_FILE = ".\\src\\FDREconomics.txt";
    private static final String Decrypted_FILE = ".\\src\\FDREconomicsDecrypted.txt";
    private static final String Compressed_DAT_FILE = ".\\src\\FDREconomicsCompressed";
    private static final int NUM_CHARS = 128;

    private static final String VIGENERE_KEYS[] = 
	{"a", "ab", "cab", "bacd", "becad","fabced","fedgabc","badcfegh","diagbecfh", 
	  "jabfigched","kebcidjafgh","ladbickjefgh","mighkcabdlefj","nmigheabcdfjkl"};

    public static void main (String[] args) throws Exception
    {
        // Huffman object - for compress\decompress
        Huffman huff = new Huffman (NUM_CHARS);

        // Read in the whole plaintext file to a string
        System.out.println ("(1) Read original file: " + INPUT_FILE);
        String text = readFile (INPUT_FILE);

        File file = new File (INPUT_FILE);
        long originFileSize = file.length();

        System.out.println ("(2) Original file size: " + originFileSize);

        // Write out the file compressed with encryption
        // compress file and return as a binary string
        String binStr = huff.compress(text);

        // BitStream handler object for doing binary to string conversions
        // Write the binary string to a binary dat file
        BitStreamHandler bitStreamHandler = new BitStreamHandler (binStr.length());
        bitStreamHandler.writeStreamToFile (binStr, Compressed_DAT_FILE + ".dat");

        System.out.println ("(3) Compressed original file (no encryption): " + Compressed_DAT_FILE + ".dat");

        String percCompStr = compPerc (INPUT_FILE, (Compressed_DAT_FILE + ".dat"));

        System.out.println ("(4) Compressed original file: " + percCompStr);


        // Try different keys for encrypting and check how compression is
        // affected by comparing the .dat file sizes produced by the different keys
        for (int key = 0; key < VIGENERE_KEYS.length; key++)
        {
            System.out.println();

            // Vigenere object for encrypt file with Key from list
            System.out.println ("(5) Encrypt original file using key: '" + VIGENERE_KEYS[key] + "'");

            Vigenere vig = new Vigenere (NUM_CHARS - 1, VIGENERE_KEYS[key]);
            String message = vig.encrypt (text);

            // Compress file and return as a binary string
            binStr = huff.compress (message);

            // Write the binary string to a binary dat file

            bitStreamHandler = new BitStreamHandler (binStr.length());
            bitStreamHandler.writeStreamToFile(binStr, Compressed_DAT_FILE + key + ".dat");

            System.out.println ("(6) Compressed encrypted file: " + Compressed_DAT_FILE + key + ".dat");

            file = new File (Compressed_DAT_FILE + key + ".dat");
            long fileSize = file.length();

	    percCompStr = compPerc (INPUT_FILE, (Compressed_DAT_FILE + key + ".dat"));

	    System.out.println ("(7) Compressed encrypted file: " + percCompStr);

            // Read the compressed file into a binary string
            String binStrIn = bitStreamHandler.readBits (Compressed_DAT_FILE + key + ".dat");

            // Decompress the binary string into the encrypted message
            message = huff.decompress (binStrIn);

            // Note - you could just use the same Vigenere object, but
            // generally, the encrypt is done on a different machine than
            // the decrypt, so simulating that here ...

            vig = new Vigenere (NUM_CHARS - 1, VIGENERE_KEYS[key]);
            String text2 = vig.decrypt (message);

            if (text.compareTo (text2) != 0)
            {
                System.out.print("Ohhhh noooooooooooooo, Mr Bill!" + "\n" +
                      "We've been hacked... The message is not the same !"+ "\n");
		System.exit (-1);
            }

            // Printwriter for writing files
            // Write the decrypted message to a file and compare with original

            PrintWriter writer = new PrintWriter (Decrypted_FILE);

            System.out.println ("(8) Decrypted file: " + Decrypted_FILE + " is the same as original");

            writer.write (text2);
            writer.close();
        }
    }

    /**
     * Reads the input file into a String
     *
     * @param filepath	Path to the file to be read.
     */
    private static String readFile (String filepath) throws Exception
    {
        String text = "";
        Scanner input;

        File file = new File (filepath);

	// The useDelimiter method saves the newline character

        input = new Scanner (file).useDelimiter ("");
        
	while (input.hasNext())
        {
            text += input.next();
        }
        
	input.close();
        return text;
    }

    /**
     * Returns a string with the percent compression
     */
    private static String compPerc (String originFile, String compFile)// throws Exception
    {
        File file1 = new File (originFile);
        int originalFileSize = (int) file1.length();
        double origFileSize = (double) originalFileSize;
        
	    File file2 = new File (compFile);
        int compFileSize = (int) file2.length();

	    int diff = originalFileSize - compFileSize;
        double perc = diff/origFileSize;
	    double percComp = (Math.round(perc * 1000d)/10d);
        return (percComp + "%"); 
    }
}
