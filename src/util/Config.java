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
public class Config 
{
    public static final Coordinate positMid = new Coordinate(0,0);
    public static final Coordinate positLeft = new Coordinate(-7, 0);
    public static final Coordinate positRigt = new Coordinate(7,0);
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
    
    // Joystick
    public static final int ps3Port = 1;
    public static final int ps3Buttons = 13;
    
    // DriverStation channels
    public static final int stAnalogAutoStartX = 1;
    public static final int stAnalogAutoStartY = 2;
    public static final int stAnalogAutoEndX = 3;
    public static final int stAnalogAutoEndY = 4;
    public static final int stDigInAutoCtr = 1;
    public static final int stDigInAutoLft = 2;
    public static final int stDigInAutoRght = 3;
    public static final int stDigInReg = 4;
    
    // Driverstation line
    public static final int stLineFile = 2;
    public static final int stLineAutonomous = 3; 
}