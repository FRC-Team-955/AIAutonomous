/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Pedro
 */
public class Coordinate 
{
    private double x;
    private double y;
    
    public Coordinate(double newX, double newY)
    {
        x = newX;
        y = newY;
    }
    
    public void setXY(double newX, double newY)
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
