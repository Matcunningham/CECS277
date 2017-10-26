/* Mathew Cunningham
   October 21, 2017
   Purpose: To model the behaviors and attributes of an ice cream cone.
   Inputs: None
   Output: None
*/
package streamio;
import java.util.*;
/**
*  This class is used to model the properties and behaviors of an ice cream cone.
*  There are currently restriction on the construction of the cone: only one
*  flavor of ice cream is allowed.
*/
public class AdvancedIceCreamCone {
    private int numberOfScoops;
    private String flavor;
    private String typeOfCone;
    private ArrayList<String> toppings = new ArrayList<String>();
    /**
    * the default constructor creates a one scoop, 
    * vanilla ice cream cone using the regular type of cone and no toppings
    */
    public AdvancedIceCreamCone() {
        numberOfScoops = 1;
        flavor = "vanilla";
        typeOfCone = "regular";
    }

    /**
     * this constructor lets you create an ice cream code to your liking.
     * @param ns the number of scoops
     * @param flv the flavor of ice cream
     * @param cone the type of cone
     */
    public AdvancedIceCreamCone(int ns, String flv, String cone) {
        numberOfScoops = ns;
        flavor = flv;
        typeOfCone = cone;
    }
    
    /**
     * this method returns the number of scoops in the cone
     * @return number of scoops
     */
    public int getNumberOfScoops() {
        return numberOfScoops;
    }
    
    /**
     * this method returns the ice cream flavor
     * @return flavor of ice cream
     */
    public String getFlavor() {
        return flavor;
    }
    /**
     * this method returns the type of cone
     * @return type of cone
     */
    public String getTypeOfCone() {
        return typeOfCone;
    }
    
    /**
     * this method allows you to add one scoop of ice cream at a time
     */
    public void addScoop() {
        numberOfScoops = numberOfScoops + 1;
    }
    
    /**
     * this method allows you to change the ice cream flavor
     * @param flv the flavor the ice cream will be changed to
     */
    public void setFlavor(String flv) {
        flavor = flv;
    }
    
    /**
     * this method allows you to change the type of cone
     * @param cone the type that the cone will be changed to
     */
    public void setTypeOfCone(String cone) {
        typeOfCone = cone;
    }
    
    /**
     * this method allows you to add toppings
     * @param top topping to be added
     */
    public void addToppings(String top) {
        toppings.add(top);
    }

    /**
     * this method returns a String with a list of the toppings
     * @return list of toppings
     */
    public ArrayList<String> getToppings() {
        return toppings;
    }
    
    /**
     * returns the number of toppings the cone has in it's current state
     * @return number of toppings
     */
    public int getNumberOfToppings()
    {
        int count = 0;
        for (String topping : this.getToppings())
        {
            count++;
        }
        return count;
    }
    
    /**
     * Sets the cone to the state passed by the memento
     * @param memento the memento used to restore the cone
     */
    public void restore(Memento memento)
    {
        flavor = memento.getFlavor();
        numberOfScoops =  memento.getNumberOfScoops();
        typeOfCone = memento.getTypeOfCone();
        toppings.clear();
        for(String topping: memento.getToppings())
        {
            toppings.add(topping);
        }
        System.out.println("Selection restored to: " + this);
    }
    
    /**
     * Saves the current cone as a Memento object.
     * @return memento of the current state
     */
    public Memento save()
    {
        return new Memento(this);
    }
    
     /**
     * Algorithm to calculate the cost of the cone 
     * @return the cones total price
     */
    public double calcPrice()
    {
        double flavPrice;
        switch (this.getFlavor()) {
            case "chocolate":
            case "vanilla":
                flavPrice = 1.25;
                break;
            case "strawberry":
                flavPrice = 1.50;
                break;
            default:
                flavPrice = 1.75;
                break;
        }
        return this.getNumberOfScoops() * flavPrice + this.getNumberOfToppings();
    }
    
    /**
     * this method overrides the inherited toString()
     * @return cone as a string
     */
    public String toString() {
        return ("The number of scoops is " + numberOfScoops + ". The flavor is "
                + flavor + ". And the type of cone is " + typeOfCone + " and the toppings are: " + getToppings());
    }
}
