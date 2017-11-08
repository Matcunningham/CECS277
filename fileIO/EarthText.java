/* Mathew Cunningham
   November 8, 2017
   Purpose: To send and receive Earth messages.
   Inputs: Message from user, file to be read from.
   Output: Message to file.
*/

package fileio;
import java.io.*;
import java.util.*;

/**
 * This class sends and receives Earth messages, it utilizes the universal translator to send alien messages.
 */
public class EarthText implements EarthCellPhone {

    UT uniTrans;
    
    /**
     * Sends message or passes to universal translator.
     * @param languageType the language the message will be in
     * @param fileName the file to write the message to
     * @throws InvalidLanguageException 
     */
    @Override
    public void sendMessage(String languageType, String fileName) throws InvalidLanguageException 
    {
        if(languageType.equalsIgnoreCase("earth"))
        {

            Scanner console = new Scanner(System.in);                
            File inFile = new File(fileName);

            while(inFile.exists())
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
                o.println(line);
                System.out.println("Message written to " + fileName + " : " + line);
            }
            
            catch(IOException exception)
            {
                System.out.println("Problem with file, please retry");
            }
        }
        else if(languageType.equalsIgnoreCase("vulcan") || languageType.equalsIgnoreCase("klingon") || languageType.equalsIgnoreCase("ferrengi"))
        {
            uniTrans = new UT(languageType);
            uniTrans.translate(languageType, fileName);
        }
        else
        {
            throw new InvalidLanguageException("Invalid Language");
        }
    }

    /**
     * Reads messages.
     * @param languageType the language the message is in
     * @param fileName the file to be read from
     */
    @Override
    public void readMessage(String languageType, String fileName) 
    {

        try (Scanner fin = new Scanner(new File(fileName)))
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
            System.out.println("Could not find file " + fileName);
        }
        
    }
}
