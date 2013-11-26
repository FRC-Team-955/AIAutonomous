/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package core;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import util.Config;
import util.MyGyro;
import util.MyUltrasonic;
import util.Vector;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot 
{   
    Drive drive;
    MyGyro gyro;
    Encoder enc_left;
    Encoder enc_right;
    MyUltrasonic sonic;
    
    public void robotInit() 
    {
        enc_left = new Encoder(5,4);
        enc_right = new Encoder(9,10);
        sonic = new MyUltrasonic(6);
        gyro = new MyGyro(8);
        drive = new Drive(enc_left, enc_right, sonic, gyro);
    }

    public void autonomousInit()
    {
        drive.init();
    }
    
    public void autonomousPeriodic() 
    {
        drive.run();
    }
	
    public void teleopPeriodic()
    {
    }
}
