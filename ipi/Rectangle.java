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
public class Rectangle extends GeometricObject
{
    private double width;
    private double height;
    
    public Rectangle()
    {
        width = 1.0;
        height = 1.0;
    }
    
    public Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }
    
    public double getHeight()
    {
        return height;
    }
    
    public void setHeight(double h)
    {
        height = h;
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public void setWidth(double w)
    {
        width = w;
    }
    
    public double getPerimeter()
    {
        return width * 2 + height * 2;
    }
    
    public double getArea()
    {
        return width * height;
    }
}
