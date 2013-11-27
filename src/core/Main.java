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
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Vector v_path;
    Drive drive;
    MyGyro gyro;
	Encoder enc_left;
	Encoder enc_right;
	MyUltrasonic usrf;
    public void robotInit() 
    {
		drive = new Drive();
		enc_left = new Encoder(5,4);
		enc_right = new Encoder(9,10);
		usrf = new MyUltrasonic(6);
    }


    public void autonomousInit()
    {
		v_path = new Vector(Config.positMid, Config.dest);
		enc_left.reset();
		enc_right.reset();
		gyro.reset();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
		enc_left.start();
		enc_right.start();
    }
	
	public void disableInit() {
		enc_left.reset();
		enc_left.reset();
		gyro.reset();
	}
	
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
    }
    
    /**
     * This function is called periodically during test mode
     */	
}
