/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Merfoo
 */
public class Point 
{
    private double x;
    private double y;
    
    public Point(double newX, double newY)
    {
        x = newX;
        y = newY;
    }
    
    public void setPoint(double newX, double newY)
    {
        x = newX;
        y = newY;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
}
