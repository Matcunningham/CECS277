/* Mathew Cunningham
   November 8, 2017
   Purpose: To create an exception for an invalid language.
   Inputs: None
   Output: None
*/

package fileio;

/**
 * An exception for languages that are not supported.
 */
public class InvalidLanguageException extends IllegalArgumentException 
{
    /**
     * Default constructor
     */
    public InvalidLanguageException() {}
    
    /**
     * Constructor that takes message.
     * @param message the message to be displayed.
     */
    public InvalidLanguageException(String message)
    {
        super(message);
    }
    
}
