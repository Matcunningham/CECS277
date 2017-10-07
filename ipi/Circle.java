/* Mathew Cunningham
   September 27, 2017
   Purpose: A circle child of the GeometricObject class.
   Inputs: None
   Output: None
*/
package ipi;

/**
 * Child of GeometricObject, has a radius.
 * 
 */
public class Circle extends GeometricObject
{
    private double radius;
    
    /**
     * Constructs a default circle of radius 1.0
     */
    public Circle()
    {
        radius = 1.0;
    }
    /**
     * Overloaded constructor
     * @param r the radius the constructed circle will have
     */
    public Circle(double r)
    {
        radius = r;
    }
    /**
     * Overloaded constructor
     * @param r the radius
     * @param c the color
     * @param f filled or not filled
     */
    public Circle(double r, String c, boolean f)
    {
        radius = r;
        super.setColor(c);
        super.setFilled(f);
    }
    /**
     * returns the radius
     * @return the radius
     */
    public double getRadius()
    {
        return radius;
    }
    /**
     * sets the radius
     * @param r the radius
     */
    public void setRadius(double r)
    {
        radius = r;
    }
    /**
     * returns the area of the circle
     * @return the area
     */
    public double getArea()
    {
        return Math.pow(radius, 2) * Math.PI;
    }
    /**
     * returns the perimeter of the circle
     * @return the perimeter
     */
    public double getPerimeter()
    {
        return radius * 2 * Math.PI;
    }
    /**
     * returns the diameter of the circle
     * @return the diameter
     */
    public double getDiameter()
    {
        return radius * 2;
    }
    /**
     * Overrides toString
     * @return the circle represented as a string
     */
    public String toString()
    {
        return "Circle: (Radius: " + getRadius() + ", Diameter: " + getDiameter() + 
               ", Perimeter: " + getPerimeter() + ", Area: " + getArea() + ")";
    }
}
