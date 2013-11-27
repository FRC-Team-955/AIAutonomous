/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import util.Config;
import util.Coordinate;
import util.Vector;

/**
 *
 * @author Merfoo
 */
public class Drive 
{
    private double motorLeftSpeed;
    private double motorRightSpeed;
    private Talon motorLeft;
    private Talon motorRight;
    public Vector destination;
			
    public Drive()
    {
        motorLeft = new Talon(Config.chanMotorLeft);
        motorRight = new Talon(Config.chanMotorRight);
    }
	
    public void setSpeed(double left, double right)
    {
        motorLeft.set(left);
        motorRight.set(right);
    }
    
    public double getLeftSpeed()
    {
        return motorLeft.get();
    }
    
    public double getRightSpeed()
    {
        return motorRight.get();
    }
}