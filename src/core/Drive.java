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
import util.Gyro;
import util.Ultrasonic;
import util.Vector;

/**
 *
 * @author Pedro
 */
/*TODO: EVERYTHING COMPARED TO AN EXACT VALUE NEEDS A RANGE*/
public class Drive 
{
    private double distance, mod, x, y, offset, pi;
    private int turns_l, turns_r;
    private Encoder enc_left, enc_right;  
    private Talon motorLeft, motorRight;
    private Ultrasonic sonic;
    private Gyro gyro;
    public Vector v_path;
			
    public Drive(Encoder left, Encoder right, Ultrasonic sonic, Gyro gyro)
    {
        motorLeft = new Talon(Config.chanMotorLeft);
        motorRight = new Talon(Config.chanMotorRight);
        mod = Config.outerArc; //Need experimental data to calculate mod
        pi = Math.PI;
        enc_left = left;
        enc_right = right;
        this.sonic = sonic;
        this.gyro = gyro;
    }
    
    public void init() {
        v_path = new Vector(Config.positMid, Config.dest); //v_path needs real data
        enc_left.reset();
        enc_right.reset();
        enc_left.start();
        enc_right.start();
        gyro.reset();
        turns_l = 0;
        turns_r = 0;
    }
    
    public void run() {
        distance = enc_right.getDistance()-mod*turns_l;
        findXY();
        //SKETCH CODE
        //setmotors blahblah until forward 15ish feet
        //v_path = new Vector(x, y);
        //Break v_path into component vectors
        //use turnLeft and turnRight to drive along component vectors
        //if obstacle do avoidObstacle
        //END OF SKETCH CODE
        //Note to self: some protocols with CTE might require PID/PD control
        //Example: a driveStraight() method. Calculate derivative using encoders
        //Maybe make x and y a single Coordinate object
    }
    
    private void turnLeft() {
        turns_l++;
        //TODO: actual protocol, need some experimental data
        offset = distance;
    }
    
    private void turnRight() {
        turns_r++;
        //TODO: actual protocol, need some experimental data
        offset = distance;
    }
    
    private void findXY() { //TODO: rewrite this more succinctly
        double angle = gyro.getAbsAngle();
        if(angle == 0)
            y += distance - offset;
        else if(angle == -pi/2 || angle == 3*pi/2)
            x -= distance - offset;
        else if(Math.abs(angle) == pi)
            y -= distance - offset;
        else if(angle == pi/2 || angle == -3*pi/2)
            x += distance - offset;
    }
    
    private void avoidObstacle() {
        //TODO: actually write this, need experimental data
    }
    
    private void setSpeed(double left, double right)
    {
        motorLeft.set(left);
        motorRight.set(right);
    }
    
    private double getLeftSpeed()
    {
        return motorLeft.get();
    }
    
    private double getRightSpeed()
    {
        return motorRight.get();
    }
}