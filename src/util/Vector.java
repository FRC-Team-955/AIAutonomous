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
public class Vector 
{
    private double theta;
    private double distance;
    
    public Vector(double newTheta, double newDist)
    {
        theta = newTheta;
        distance = newDist;
    }
    
    public void setVector(double newTheta, double newDist)
    {
        theta = newTheta;
        distance = newDist;
    }
    
    public Coordinate getXY()
    {
        int signX;
        int signY;
        Coordinate ret;
               
        if(Math.abs(theta)<90)
            signY = 1;
        
        else
            signY = -1;
        
        if(theta/Math.abs(theta)==1)
            signX = 1;
        
        else 
            signX = -1;
        
        ret = new Coordinate(distance*Math.cos(theta)*signX, distance*Math.sin(theta)*signY);
        return ret;
    }
    
    public double getTheta()
    {
        return theta;
    }
    
    public double getDistance()
    {
        return distance;
    }
}
