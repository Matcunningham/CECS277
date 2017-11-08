/* Mathew Cunningham
   November 8, 2017
   Purpose: To act as an adapter between alien and earth messages.
   Inputs: None
   Output: None
*/

package fileio;

/**
 * This is the adapter class (Universal Translator).
 */
public class UT  
{
    AlienCellPhone alienCell;
    
    /**
     * Takes the language to be translated to and creates a new instance of it.
     * @param languageType the language to be translated to
     */
    public UT(String languageType)
    {
        if(languageType.equalsIgnoreCase("klingon"))
        {
            alienCell = new KlingonText();
        }
        else if(languageType.equalsIgnoreCase("vulcan"))
        {
            alienCell = new VulcanText();
        }
        else
        {
            alienCell = new FerrengiText();
        }
    }
    
    /**
     * Calls the appropriate alien translate method.
     * @param languageType the language to be translated to
     * @param fileName the file to be written to
     */
    public void translate(String languageType, String fileName)
    {
        alienCell.translateText(languageType, fileName);
    }
}
