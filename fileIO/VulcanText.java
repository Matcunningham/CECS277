/* Mathew Cunningham
   November 8, 2017
   Purpose: To translate and read Vuclan messages.
   Inputs: Message from user to translate, File with message to read.
   Output: Translated message to console and to file.
*/

package fileio;
import java.io.*;
import java.util.*;

/**
 * This class translates and reads Earth messages to Vulcan.
 */
public class VulcanText implements AlienCellPhone {

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
     * @param fileName the file to be read from
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
     * Translates Earth messages to Vulcan (backwards String).
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
                System.out.println("Translating to Vulcan...");
                System.out.print("Translated message saved to " + fileName + ": " );
                for(int i = line.length() -  1; i >= 0; i--)
                {
                    o.print(line.charAt(i));
                    System.out.print(line.charAt(i)); // Print to console for verification
                }
                System.out.println();
            }
            readText(languageType, inFile.toString());
        }
        catch(IOException exception)
        {
            System.out.println("Problem with file, please retry");
        }        
    }
}
