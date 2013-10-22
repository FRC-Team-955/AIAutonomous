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
    
    public double getTheta()
    {
        return theta;
    }
    
    public double getDistance()
    {
        return distance;
    }
}
