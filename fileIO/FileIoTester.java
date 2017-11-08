/* Mathew Cunningham
   November 8, 2017
   Purpose: To implement the user interface and test the project.
   Inputs: User input.
   Output: User prompts and message verification.
*/

package fileio;
import java.util.*;

/**
 * Main user interface.
 */
public class FileIoTester {
    public static void main(String[] args) {
        EarthText e1 = new EarthText();
        boolean flag = true;
        Scanner console = new Scanner(System.in);        
        System.out.print("Hello Earth user, ");   
        while(flag)
        {
            System.out.print("please enter 'send' to send a message, 'read' to read a message, or 'quit': ");
            String input = console.nextLine();
            if(input.equalsIgnoreCase("send"))
            {
                System.out.println("Please enter the language understood by your recipient(Earth, Klingon, Vulcan, or Ferrengi):");
                String languageType = console.nextLine();
                System.out.println("Please enter a file name to write the message to: ");
                String fileName = console.nextLine();
                try
                {
                    e1.sendMessage(languageType, fileName);
                }
                catch(InvalidLanguageException ile)
                {
                    System.out.println(ile.getMessage());
                }            
            }
            else if(input.equalsIgnoreCase("read"))
            {
                System.out.println("Please enter a file name to read the message from: ");
                String fileName = console.nextLine();
                e1.readMessage("earth", fileName);
            }
            else if(input.equalsIgnoreCase("quit"))
            {
                console.close();
                flag = false;
            }
            else
            {
                System.out.println("You must enter 'send', 'read', or 'quit'");
            }
        }     
    } 
}