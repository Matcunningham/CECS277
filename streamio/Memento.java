/* Mathew Cunningham
   October 21, 2017
   Purpose: To maintain the state of an AdvancedIceCreamCone object.
   Inputs: None
   Output: None
*/
package streamio;
import java.io.*;
import java.util.ArrayList;

/**
 * The Memento class is used to maintain the state of AdvancedIceCreamCone
 */
public class Memento implements Serializable {
    
    private int numberOfScoops;
    private String flavor;
    private String typeOfCone;
    private ArrayList<String> toppings = new ArrayList<String>();
    
    /**
     * Constructs a Memento from an AdvancedIceCreamCone
     * @param cone the cone that the Memento will be created from.
     */
    public Memento(AdvancedIceCreamCone cone)
    {
        numberOfScoops = cone.getNumberOfScoops();
        flavor = cone.getFlavor();
        typeOfCone = cone.getTypeOfCone();
        for(String topping: cone.getToppings())
        {
            toppings.add(topping);
        }
    }
    
    /**
     * returns number of scoops
     * @return number of scoops
     */
    public int getNumberOfScoops() {
        return numberOfScoops;
    }
    
    /**
     * returns flavor of ice cream
     * @return flavor
     */
    public String getFlavor() {
        return flavor;
    }
    
    /**
     * returns type of ice cream cone
     * @return type of cone
     */
    public String getTypeOfCone() {
        return typeOfCone;
    }
    
    /**
     * returns list of toppings
     * @return list of toppings
     */
    public ArrayList<String> getToppings() {
        return toppings;
    }
}
