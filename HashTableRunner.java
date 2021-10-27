import java.util.Scanner;
import java.io.File;

import java.util.*;
public class HashTableRunner
{
    public static void main (String[] args)
    {
        try{
            //create a HashTable object. It should have a tableSize of 10 if you're using words.txt. 
            //Change the size of the HashTable appropriately if you are using Raven.txt. 
            HashTable h = new HashTable(10);
            
            Scanner infile = new Scanner(new File("words.txt"));
            while (infile.hasNext())
            {    
                String curr = infile.nextLine();
                Word temp = new Word(curr);
                h.add(temp);
                // 1) get a String from input
                // 2) make a Word
                // 3) add it to the table)        
            }
            System.out.println(h);
            System.out.println(h.size());
            System.out.println(h.longestChain());
            
            //output the table
            //output the number of unique words
            //output the length of the longest chain in the table
        }
        catch(Exception e)
        {
            System.out.println("Houston, we have a problem! That file is not found.");
            e.printStackTrace();
        }
    }
}