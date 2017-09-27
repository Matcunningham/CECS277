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
public class Part1Tester {
    
    public static void main(String[] args)
    {
        Circle circ1 = new Circle();
        //circ1.setColor("blue");
        String x = circ1.getColor();
        System.out.println(x);
        double y = circ1.getRadius();
        System.out.println(y);
        System.out.println(circ1.toString());
        
        Triangle tri = new Triangle(5,4,3);
        System.out.println(tri.toString());
        System.out.println(tri.getArea());
        System.out.println(tri.getPerimeter());
    }
    
}
