/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipi;

/**
 *
 * @author Mat
 */
public class Triangle extends GeometricObject
{
    double side1;
    double side2;
    double side3;
    
    public Triangle()
    {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double s1, double s2, double s3)
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    
    public double getS1()
    {
        return side1;
    }

    public double getS2()
    {
        return side2;
    }
    
    public double getS3()
    {
        return side3;
    }    
    
    public double getPerimeter()
    {
        return side1 + side2 + side3;
    }
    
    public double getArea()
    {
        double hPerim = this.getPerimeter() / 2;
        double areaEq = hPerim * (hPerim - side1) * (hPerim - side2) * (hPerim - side3);
        return Math.sqrt(areaEq);
    }    
    
    public String toString()
    {
        return "Side 1 is " + side1 + " Side 2 is " + side2 + " Side 3 is " + side3;
    }
}
