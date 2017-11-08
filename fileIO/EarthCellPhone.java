/* Mathew Cunningham
   November 8, 2017
   Purpose: An interface for sending and reading messages.
   Inputs: None
   Output: None
*/

package fileio;

/**
 * Classes that implement this interface must send and read messages.
 */
public interface EarthCellPhone 
{
    /**
     * @param languageType the language of the message to be sent
     * @param fileName the file to be written to
     * @throws InvalidLanguageException 
     */
   public void sendMessage(String languageType, String fileName) throws InvalidLanguageException;
   
   /**
    * @param languageType the language type to be read
    * @param fileName the file to be read from
    */
   public void readMessage(String languageType, String fileName);
}