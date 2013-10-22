/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import com.sun.squawk.util.MathUtils;

/**
 *
 * @author Merfoo
 */
public class Config 
{
    // PWM
    public static final int chanMotorLeft = 1;
    public static final int chanMotorRight = 2;
    
    // Analog
    public static final int chanEncLeftA = 1;
    public static final int chanEncLeftB = 2;
    public static final int chanEncRightA = 3;
    public static final int chanEncRightB = 4;
    public static final int chanGyro = 5;
    public static final int chanUltrasonic = 6;
    
    // Ints
    public static final int ps3Port = 1;
    public static final int ps3Buttons = 13;
    
    // DriverStation channels
    public static final int stAnalogAutoX = 1;
    public static final int stAnalogAutoY = 2;
    public static final int stDigInAutoCtr = 1;
    public static final int stDigInAutoLft = 2;
    public static final int stDigInAutoRght = 3;
    public static final int stDigInReg = 4;
    
    // Driverstation line
    public static final int stLineFile = 2;
    public static final int stLineAutonomous = 3;
    
    public static double sin(double theta)
    {
        return Math.toDegrees(Math.sin(Math.toRadians(theta)));
    }
    
    public static double cos(double theta)
    {
        return Math.toDegrees(Math.cos(Math.toRadians(theta)));
    }
    
    public static double getDistance(Coordinate pointA, Coordinate pointB)
    {
        double x = pointA.getX() - pointB.getX();
        double y = pointA.getY() - pointB.getY();
        
        return Math.sqrt((x*x) + (y*y));
    }
    
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
        
        return Math.toDegrees(MathUtils.atan(y/x));
    }
    
    /**
     * Sets the double to be only at the hundreth's place, ex. 12.34.
     */
    public static double SetDoublePrecision(double dDouble)
    {
        return (Double.valueOf(Math.floor(dDouble * 10 + 0.5) / 10)).doubleValue();
    }
}