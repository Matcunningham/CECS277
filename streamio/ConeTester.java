/* Mathew Cunningham
   October 21, 2017
   Purpose: To test the AdvancedIceCreamCone class utilizing the memento design pattern.
   Inputs: None
   Output: Prints the cone attributes as they change, the restored cone, and total price.
*/
package streamio;
import java.io.*;

public class ConeTester {
    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException
    {
        CreamCaretaker caretaker = new CreamCaretaker("conemento"); // Creates caretaker with given filename
        
        AdvancedIceCreamCone cone = new AdvancedIceCreamCone();
        System.out.println("The new cone is: " + cone);
        cone.addToppings("Nuts");
        cone.addToppings("Cookie Dough");
        System.out.println("The cone is now: " + cone + "\n");        
        caretaker.addMemento(cone.save());
        
        cone = new AdvancedIceCreamCone(2, "Mimi's Minty", "waffle");
        System.out.println("Cone 2 is: " + cone);
        cone.addToppings("Chips");
        caretaker.addMemento(cone.save());
        
        cone.setFlavor("chocolate");
        cone.addToppings("Sprinkles");
        cone.setTypeOfCone("sugar");
        cone.addScoop();
        System.out.println("Cone 2 is now: " + cone);
        caretaker.addMemento(cone.save());
        
        cone.setFlavor("strawberry");
        cone.addToppings("Fudge");
        cone.setTypeOfCone("waffle");
        cone.addToppings("Nuts");
        System.out.println("Cone 2 is now: " + cone + "\n");
        
        cone.restore(caretaker.getMemento("chocolate"));
        System.out.println("Total Price: $" + cone.calcPrice());
        System.out.println("*Expected Price: " + (1.25 * 3 + 2)); // For chocolate with 3 scoops and 2 toppings    

    } 
}
