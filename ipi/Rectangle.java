/* Mathew Cunningham
   September 27, 2017
   Purpose: A rectangle child of the GeometricObject class.
   Inputs: None
   Output: None
*/
package ipi;

/**
 * Child of GeometricObject, had a width and a height.
 */
public class Rectangle extends GeometricObject
{
    private double width;
    private double height;
    
    /**
     * Default constructor, width and height are both 1.0
     */
    public Rectangle()
    {
        width = 1.0;
        height = 1.0;
    }
    
    /**
     * Overloaded constructor
     * @param w the width
     * @param h the height
     */
    public Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }
   
    /**
     * Overloaded constructor
     * @param w the width
     * @param h the height
     * @param c the color
     * @param f filled or not filled
     */
    public Rectangle(double w, double h, String c, boolean f)
    {
        width = w;
        height = h;
        super.setColor(c);
        super.setFilled(f);
    }
    
    /**
     * returns the height of the rectangle
     * @return the height
     */
    public double getHeight()
    {
        return height;
    }
    
    /**
     * sets the height of the rectangle
     * @param h the height that will be set
     */
    public void setHeight(double h)
    {
        height = h;
    }
    
    /**
     * returns the width of the rectangle
     * @return the width
     */
    public double getWidth()
    {
        return width;
    }
    
    /**
     * sets the width of the rectangle
     * @param w the width that will be set
     */    
    public void setWidth(double w)
    {
        width = w;
    }
    
    /**
     * returns the perimeter of the rectangle.
     * @return the perimeter
     */
    public double getPerimeter()
    {
        return width * 2 + height * 2;
    }
    
    /**
     * returns the area of the rectangle
     * @return the area
     */
    public double getArea()
    {
        return width * height;
    }
    
    /**
     * Overrides the toString method
     * @return the rectangle represented as a string
     */
    public String toString()
    {
        return "Rectangle: (Height: " + getHeight() + ", Width: " + getWidth() +
               ", Perimeter: " + getPerimeter() + ", Area: " + getArea() + ")";
    }
}
