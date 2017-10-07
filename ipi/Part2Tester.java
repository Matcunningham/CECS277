/* Mathew Cunningham
   September 27, 2017
   Purpose: To test the modified GeometricObject class.
   Inputs: None
   Output: GeometricObject with larger area for sets of rectangles, triangles, circles. 
           A sorted ArrayList of each of those GeometricObjects.
*/

package ipi;
import java.util.*;

/**
 * This is a test class for part 2 of the project it tests the GeometricObject 
 * class and it's children.
 */
public class Part2Tester {
    
    public static void main(String[] args)
    {
        Rectangle square = new Rectangle(2,2);
        Rectangle defaultRec = new Rectangle();
        Circle circ1 = new Circle(3);
        Circle defaultCirc = new Circle();
        Triangle tri = new Triangle();
        Triangle defaultTri = new Triangle(3,4,5);
        ArrayList<GeometricObject> gArray = new ArrayList<GeometricObject>();
        gArray.add(square);
        gArray.add(defaultRec);
        gArray.add(circ1);
        gArray.add(defaultCirc);
        gArray.add(tri);
        gArray.add(defaultTri);
        
        GeometricObject a = GeometricObject.max(square, defaultRec);
        GeometricObject b = GeometricObject.max(circ1, defaultCirc);
        GeometricObject c = GeometricObject.max(tri, defaultTri);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c + "\n");
        
        Collections.sort(gArray);
        System.out.println(gArray);
    }
    
}
