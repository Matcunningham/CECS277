/* Mathew Cunningham
   October 21, 2017
   Purpose: To maintain saved Memento objects.
   Inputs: Reads in Memento objects from file.
   Output: Writes Memento objects to file.
*/
package streamio;
import java.io.*;

/**
 * The CreamCaretaker keeps track of multiple Memento objects. 
 */
public class CreamCaretaker  {
    FileOutputStream fos;
    FileInputStream fis;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    String file;
    
    /**
     * Constructs a caretaker and creates filename
     * @param filename the file to be created
     */
    CreamCaretaker(String filename)
    {
        file = filename;
    }
    
    /**
     * Adds Memento object to the file.
     * @param m the Memento to be added
     * @throws IOException 
     */
    public void addMemento(Memento m) throws IOException 
    {
        if(fos == null)
        {
            fos = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fos);
        }
        oos.writeObject(m);
    }
    
    /**
     * Reads Memento object from file
     * @param flavor the flavor of ice cream to be retrieved from file
     * @return Memento retrieved by the flavor
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public Memento getMemento(String flavor) throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        if(fis == null)
        {
            oos.close();
            fos.close();            
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);  
        }

        Memento m = (Memento) ois.readObject();
        String mFlav = m.getFlavor();
        boolean flavMatch = mFlav.equalsIgnoreCase(flavor); 
        while(!flavMatch)
        {
            m = (Memento) ois.readObject();
            mFlav = m.getFlavor();
            flavMatch = mFlav.equalsIgnoreCase(flavor);
        }
        fis.close();
        ois.close();
        return m;
    }
}

