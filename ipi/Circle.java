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
public class Circle extends GeometricObject
{
    private double radius;
    
    public Circle()
    {
        radius = 1.0;
    }

    public Circle(double r)
    {
        radius = r;
    }
    
    public double getRadius()
    {
        return radius;
    }
    
    public void setRadius(double r)
    {
        radius = r;
    }
    
    public double getArea()
    {
        return Math.pow(radius, 2) * Math.PI;
    }
    
    public double getPerimeter()
    {
        return radius * 2 * Math.PI;
    }
    
    public double getDiameter()
    {
        return radius * 2;
    }
}
