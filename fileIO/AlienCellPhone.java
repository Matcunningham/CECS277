/* Mathew Cunningham
   November 8, 2017
   Purpose: An interface for sending, reading, and translating messages.
   Inputs: None
   Output: None
*/

package fileio;

/**
 * Classes that implement this interface must send, read, and translate text.
 */
public interface AlienCellPhone 
{
    /**
     * @param languageType the language of the message to be sent
     * @param fileName the file to be written to
     */
   public void sendText(String languageType, String fileName);
   
   /**
    * @param languageType the language type to be read
    * @param fileName the file to be read from
    */
   public void readText(String languageType, String fileName);
   
   /**
    * @param languageType the language of the text to be translated
    * @param fileName the file to be written to
    */
   public void translateText(String languageType, String fileName);
}
