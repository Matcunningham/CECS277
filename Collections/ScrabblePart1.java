/* Mathew Cunningham
   November 27, 2017
   Purpose: To find the Scrabble point value for words read from a file
   Inputs: Scrabble point value file, File containing words
   Output: The words and corresponding point values.
*/
package collections;
import java.util.*;
import java.io.*;

public class ScrabblePart1 
{
    public static void main(String[] args)
    {
        System.out.println("Part 1 : Scrabble");
        
        // Loads map with letters and point value
        Map<Character,Integer> scrabble = new HashMap<>();
        try(Scanner fin = new Scanner(new File("ScrabVal.txt")))
        {
            while(fin.hasNext())
            {
                char letter = fin.next().charAt(0);
                int val = fin.nextInt();
                scrabble.put(letter, val);
                fin.nextLine();
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        // Caluclates point value, while reading words from file
        try(Scanner fin = new Scanner(new File("QWords.txt")))
        {
            while(fin.hasNext())
            {
                String word = fin.nextLine();
                word = word.toUpperCase();
                int wordVal = 0;
                for(int i = 0; i < word.length(); i++)
                {
                    wordVal = wordVal + scrabble.get(word.charAt(i));
                }
                System.out.println("The point value of " + word + " is " + wordVal);
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
