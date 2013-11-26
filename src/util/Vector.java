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
public class Vector 
{
    private double theta;
    private double distance;
    
    public Vector(double theta, double distance)
    {
        this.theta = theta;
        this.distance = distance;
    }
    
    public Vector(double initX, double initY, double finalX, double finalY)
    {
        Coordinate start = new Coordinate(initX, initY);
        Coordinate end = new Coordinate(finalX, finalY);
        
        distance = MyMath.getDistance(start, end);
        theta = MyMath.getAngle(start, end);
    }
    
    public Vector(Coordinate init, Coordinate dest) {
        distance = MyMath.getDistance(init, dest);
        theta = MyMath.getAngle(init, dest);
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
        Coordinate ret = new Coordinate(distance*Math.cos(theta), distance*Math.sin(theta));
               
        if(Math.abs(theta)<90)
            signY = 1;
        
        if(theta/Math.abs(theta)==1)
            signX = 1;
        
        
        ret.setXY(ret.getX()*signX, ret.getY()*signY);
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
