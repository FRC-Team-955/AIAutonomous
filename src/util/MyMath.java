/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.sun.squawk.util.MathUtils;

/**
 *
 * @author Merfoo
 */
public class MyMath 
{
    public static double SetDoublePrecision(double dDouble)
    {
        return (Double.valueOf(Math.floor(dDouble * 10 + 0.5) / 10)).doubleValue();
    }
    
    public static double getDistance(Coordinate pointA, Coordinate pointB)
    {
        double x = pointA.getX() - pointB.getX();
        double y = pointA.getY() - pointB.getY();
        
        return Math.sqrt((x*x) + (y*y));
    }
    
    // TODO: FIX THE DIFFERENT REFERENCE POINT CONFUSION IN ATAN AND OURS!
    public static double getAngle(Coordinate start, Coordinate end)
    {
        double x = end.getX() - start.getX();
        double y = end.getY() - start.getY();
        
        if(x == 0)
        {
            if(y > 0)
                return 0.0;
            
            return -180.0;
        }
        
        return MathUtils.atan(y/x);
    }
}
