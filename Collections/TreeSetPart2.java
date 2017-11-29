/* Mathew Cunningham
   November 27, 2017
   Purpose: To find time for inserting and searching a TreeSet
   Inputs: Alice in Wonderland text file
   Output: Time
*/

package collections;
import java.util.*;
import java.io.*;

public class TreeSetPart2 
{
    public static void main(String[] args)
    {
        System.out.println("Part 2 : TreeSet");
        
        Set<String> words = new TreeSet<>();
        try(Scanner fin = new Scanner(new File("alice.txt")))
        {
            // Insertion timing
            long time1 = System.currentTimeMillis();        
            while(fin.hasNext())
            {
                words.add(fin.next());
            }
            long time2 = System.currentTimeMillis();
            System.out.println("Time for insertion is: " + (time2-time1) + " milliseconds");

            // Search timing
            String searchWord = "Alice";
            System.out.println("Search Word: " + searchWord);            
            String currentWord = "";
            time1 = System.currentTimeMillis();
            for(int i = 0; i < 100; i++)
            {
                Iterator<String> iter = words.iterator();
                while(!searchWord.equalsIgnoreCase(currentWord))
                {
                    currentWord = iter.next();
                }
                currentWord = "";
            }
            time2 = System.currentTimeMillis();
            System.out.println("Time for searching is: " + (time2-time1) + " milliseconds"); 
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
