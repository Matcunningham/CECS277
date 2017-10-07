/* Original by Professor Opkins
   Mathew Cunningham
   September 27, 2017
   Purpose: The parent class of Circle, Triangle, Rectangle.
   Inputs: None
   Output: None
 */
package ipi;

/**
 * This class is the parent to Circle, Triangle, Rectangle.
 */
public abstract class GeometricObject implements Comparable<GeometricObject> {

    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    private String name = "noname";
    
    public abstract double getArea();
    public abstract double getPerimeter();

    /**
     * Construct a default geometric object
     */
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with the specified color and filled value
     */
    public GeometricObject(String color, boolean filled, String name) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
        this.name = name;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean, its get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @param geo1 a GeometricObject to be compared.
     * @param geo2 a second GeometricObject to be compared to the first.
     * @return the GeometricObject with the largest area.
     */
    public static GeometricObject max(GeometricObject geo1, GeometricObject geo2) 
    {
        int compare = geo1.compareTo(geo2);
        if(compare > 0 )
        {
            return geo1;
        }
        else
        {
            return geo2;
        }
    }

    /**
     * Overrides the compareTo method.
     * @param o a GeometricObject to be compared.
     * @return an integer value defining which object is larger, negative if
     *          this GeometricObject is larger, positive if GeometricObject o 
     *          is larger, and zero if they are equal.
     */
    public int compareTo(GeometricObject o)
    {
        if(this.getArea() < o.getArea())
        {
            return -6;
        }
        if(this.getArea() > o.getArea())
        {
            return 6;
        }   
        else
        {
            return 0;
        }   
    }
    
    /**
     * Return a string representation of this object
     */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color
                + " and filled: " + filled;
    }
}
