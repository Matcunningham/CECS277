/* Mathew Cunningham
   November 8, 2017
   Purpose: To translate and read Klingon messages.
   Inputs: Message from user to translate, File with message to read, Klingon dictionary file.
   Output: Translated message to console and to file.
*/

package fileio;
import java.util.*;
import java.io.*;

/**
 * This class translates and reads Earth messages to Klingon.
 */
public class KlingonText implements AlienCellPhone{

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
     * Translates Earth message to Klingon from small dictionary file,
     * unknown words are kept as Earth language.
     * @param languageType the language to be translated to
     * @param fileName the file to be written to
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
                System.out.println("Translating to Klingon...");
                System.out.print("Translated message saved to " + fileName + ": " );
                Scanner scanLine = new Scanner(line);
                File aFile = new File("klingonDict.txt");
                while(scanLine.hasNext())
                {
                    Scanner in = new Scanner(aFile);                    
                    String word = scanLine.next();
                    in.nextLine();
                    int dictCount = in.nextInt();
                    String klingText = in.nextLine(); // Sets scanner to next line
                    String englText = "";
                    int count = 0;
                    while((!(word.equalsIgnoreCase(englText))) && in.hasNextLine())
                    {
                        count++;
                        klingText = in.next();                     
                        englText = in.nextLine();
                        englText = englText.trim();

                    }                     
                    if(count == dictCount)
                    {
                        System.out.print(word + " ");
                        o.print(word + " ");                         
                    }
                    else
                    {
                        System.out.print(klingText+ " ");
                        o.print(klingText + " ");                       
                    }
                    in.close();
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