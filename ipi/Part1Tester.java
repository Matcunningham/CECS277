/* Mathew Cunningham
   September 27, 2017
   Purpose: To test the GeometricObject children.
   Inputs: None
   Output: Tests for Circle, Triangle, Rectangle. Also utilizes polymorphism
            to print perimeters.
*/
package ipi;

/**
 *  This is a test class for part 1 of the project, it tests the constructors
 *  and methods.
 */
public class Part1Tester {
    
    public static void main(String[] args)
    {
        // constructor testing
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);
        Circle c3 = new Circle(6,"blue",true);
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(2,6);        
        Rectangle r3 = new Rectangle(3,4,"orange",true);  
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle(3,4,5);        
        Triangle t3 = new Triangle(4,5,6,"yellow",true); 
        GeometricObject geoArray[] = {c1,c2,c3,r1,r2,r3,t1,t2,t3};
        
        // method testing
        // circle tests
        System.out.println("c1 = " + c1 + ", Color: " + c1.getColor() + ", Filled: " + c1.isFilled()); // Default radius = 1
        c1.setRadius(2.5);
        c1.setColor("black");
        c1.setFilled(true);
        System.out.println("c1 = " + c1 + ", Color: " + c1.getColor() + ", Filled: " + c1.isFilled());
        
        System.out.println("c2 = Radius: " + c2.getRadius() + ", Diameter: " + c2.getDiameter() + 
                           ", Perimeter: " + c2.getPerimeter() + ", Area: " + c2.getArea());          
        
        c3.setName("c3");
        System.out.println(c3.getName() + " = " + c3+ ", Color: " + c3.getColor() + ", Filled: " + c3.isFilled() + "\n");

        // rectangle tests
        System.out.println("r1 = " + r1 ); // Default height/width = 1
        r1.setHeight(1.5);
        r1.setWidth(1.5);
        System.out.println("r1 = " + r1);
        
        System.out.println("r2 = Height: " + r2.getHeight() + ", Width: " + r2.getWidth() + 
                           ", Perimeter: " + r2.getPerimeter() + ", Area: " + r2.getArea());          
        
        r3.setName("r3");
        System.out.println(r3.getName() + " = " + r3+ ", Color: " + r3.getColor() + ", Filled: " + r3.isFilled() + "\n");  
        
        // triangle tests
        System.out.println("t1 = " + t1); // default sides = 1
        t1.setS1(1.2);
        t1.setS2(1.3);
        t1.setS3(1.4);
        System.out.println("t1 = side1: " + t1.getS1() + ", side2: " + t1.getS2() + ", side3: " + t1.getS3() + 
                           ", Perimeter: " + t1.getPerimeter() + ", Area: " + t1.getArea());
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3 + ", Color: " + t3.getColor() + ", Filled: " + t3.isFilled() + "\n");
        
        // Polymorphism testing
        // Set names for better looking output
        c1.setName("c1");
        c2.setName("c2");
        r1.setName("r1");
        r2.setName("r2");
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        for (int i = 0; i < geoArray.length; i++)
        {
            System.out.println(geoArray[i].getName() + " Perimeter: " + geoArray[i].getPerimeter());

        }
    }
}
