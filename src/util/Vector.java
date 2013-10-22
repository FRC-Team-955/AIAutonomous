/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Pedro, Fauzi
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
        int signX = -1;
        int signY = -1;
        Coordinate ret = new Coordinate(distance*Config.cos(theta), distance*Config.sin(theta));
               
        if(Math.abs(theta)<90)
            signY = 1;
        
        if(theta/Math.abs(theta)==1)
            signX = 1;
        
        
        ret.setCoordinate(ret.getX()*signX, ret.getY()*signY);
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
