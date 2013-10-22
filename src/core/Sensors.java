/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;
import util.Config;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Merfoo
 */
public class Sensors 
{
    private Ultrasonic rangeFinder;
    private Encoder encLeft;
    private Encoder encRight;
    private Gyro gyro;
    
    public Sensors()
    {
        rangeFinder = new Ultrasonic(Config.chanUltrasonicOut, Config.chanUltrasonicIn);
        encLeft = new Encoder(Config.chanEncLeftA, Config.chanEncLeftB);
        encRight = new Encoder(Config.chanEncRightA, Config.chanEncRightB);
        gyro = new Gyro(Config.chanGyro);
        
        rangeFinder.setAutomaticMode(true);
        encLeft.reset();
        encLeft.start();
        encRight.reset();
        encRight.start();
        gyro.reset();
    }
    
    public void resetEncoders()
    {
        encLeft.reset();
        encRight.reset();
    }
    
    public void resetGyro()
    {
        gyro.reset();
    }
    
    public double getEncLeftDist()
    {
        return encLeft.getDistance();
    }
    
    public double getEncRightDist()
    {
        return encRight.getDistance();
    }
    
    public double getGyroTheta()
    {
        return gyro.getAngle();
    }
    
    public double getUltrasonicDist()
    {
        return rangeFinder.getRangeInches();
    }
}
