/* Mathew Cunningham
   September 27, 2017
   Purpose: A triangle child of the GeometricObject class.
   Inputs: None 
   Output: None
 */
package ipi;

/**
 * Child of GeometricObject, has 3 sides.
 */
public class Triangle extends GeometricObject 
{

    private double side1;
    private double side2;
    private double side3;

    /**
     * Default constructor, each side is 1.0
     */
    public Triangle() 
    {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    /**
     * Overloaded constructor
     * @param s1 the length of side 1
     * @param s2 the length of side 2
     * @param s3 the length of side 3
     */
    public Triangle(double s1, double s2, double s3) 
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    /**
     * Overloaded constructor
     * @param s1 the length of side 1
     * @param s2 the length of side 2
     * @param s3 the length of side 3
     * @param c the color
     * @param f filled or not filled
     */
    public Triangle(double s1, double s2, double s3, String c, boolean f) 
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
        super.setColor(c);
        super.setFilled(f);
    }

    /**
     * returns length of side 1
     * @return the length of side 1
     */
    public double getS1() 
    {
        return side1;
    }

    /**
     * Sets the length of side 1
     * @param s the length side 1 will be changed to
     */
    public void setS1(double s) 
    {
        side1 = s;
    }

    /**
     * returns length of side 2
     * @return the length of side 2
     */    
    public double getS2() 
    {
        return side2;
    }

    /**
     * Sets the length of side 2
     * @param s the length side 2 will be changed to
     */    
    public void setS2(double s) 
    {
        side2 = s;
    }

    /**
     * returns length of side 3
     * @return the length of side 3
     */    
    public double getS3() 
    {
        return side3;
    }

    /**
     * Sets the length of side 3
     * @param s the length side 3 will be changed to
     */    
    public void setS3(double s) 
    {
        side3 = s;
    }

    /**
     * returns the perimeter of the triangle
     * @return the perimeter
     */
    public double getPerimeter() 
    {
        return side1 + side2 + side3;
    }

    /**
     * returns the area of the triangle
     * @return the area
     */
    public double getArea() 
    {
        double hPerim = this.getPerimeter() / 2;
        double areaEq = hPerim * (hPerim - side1) * (hPerim - side2) * (hPerim - side3);
        return Math.sqrt(areaEq);
    }

    /**
     * Overrides the toString method
     * @return the triangle represented as a string
     */
    public String toString() 
    {
        return "Triangle: (Side 1 is " + side1 + ", Side 2 is " + side2 + ", Side 3 is "
                + side3 + ", Perimeter: " + getPerimeter() + ", Area: " + getArea() + ")";
    }
}
