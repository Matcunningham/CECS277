/* Mathew Cunningham
   November 8, 2017
   Purpose: To translate and read Ferrengi messages.
   Inputs: Message from user to translate, File with message to read.
   Output: Translated message to console and to file.
*/

package fileio;
import java.io.*;
import java.util.*;

/**
 * This class translates and reads Earth messages to Ferrengi.
 */
public class FerrengiText implements AlienCellPhone {

    /**
     * Does nothing, Aliens can not send messages yet.
     */
    @Override
    public void sendText(String languageType, String fileName) {
        // Not Supported
    }

    /**
     * Reads message from file.
     * @param languageType the language that will be read
     * @param fileName the file that will be read from
     */
    @Override
    public void readText(String languageType, String fileName) 
    {

        File inFile = new File(fileName);
        try (Scanner fin = new Scanner(inFile))
        {
            System.out.print("New Message: ");
            while(fin.hasNextLine())
            {
                String line = fin.nextLine();
                System.out.println(line);
            }
        }
        
        catch(IOException exception)
        {
            System.out.println("Could not find file" + fileName);
        }
    }        
    
    /**
     * Translates Earth messages to Ferrengi (Pig Latin).
     * @param languageType the language to be translated to
     * @param fileName the file the message will be written to
     */
    @Override
    public void translateText(String languageType, String fileName) 
    {
        try
        {
            File inFile =  new File(fileName); 
            Scanner console = new Scanner(System.in);

            while(inFile.exists()) // Checks if file exists and if user wants to overwrite
            {
                System.out.println(fileName + " already exists, overwrite? (yes/no)");
                String overWrite = console.nextLine();
                if(overWrite.equalsIgnoreCase("yes"))
                {
                    break;
                }
                else if(overWrite.equalsIgnoreCase("no"))
                {
                    System.out.print("Enter new file name: ");
                    fileName = console.nextLine();
                    inFile.renameTo(new File(fileName));
                }
                else
                {
                    System.out.println("Enter 'yes' or 'no'");
                }
            }           
 
            try (PrintWriter o = new PrintWriter(inFile)) 
            {
                System.out.println("Please type your message: ");
                String line = console.nextLine();
                System.out.println("Translating to Ferrengi...");
                System.out.print("Translated message saved to " + fileName + ": " );
                Scanner scanLine = new Scanner(line);
                String translation = "";
                while(scanLine.hasNext())
                {
                    String word = scanLine.next();
                    char letter0 = word.charAt(0);
                    char[] wordArr = word.toCharArray();
                    for(int i = 1; i < wordArr.length; i++)
                    {
                        wordArr[i-1] = word.charAt(i);
                    }
                    wordArr[wordArr.length - 1] = letter0;
                    for(int j = 0; j < wordArr.length; j++)
                    {
                        translation = translation + wordArr[j];
                    }
                    translation = translation + "ay ";
                }
                o.println(translation);
                System.out.println(translation); // Print for verification
            }
            readText(languageType, inFile.toString());
        }
        catch(IOException exception)
        {
            System.out.println("Problem with file, please retry");
        }            
    }
}
