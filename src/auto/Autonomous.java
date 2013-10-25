/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auto;

import core.Drive;
import core.Sensors;
import util.Config;
import util.MyMath;
import util.DynamicArray;
import util.Vector;
import util.Coordinate;
import util.Station;

/**
 *
 * @author Merfoo
 */
public class Autonomous 
{
    private Sensors sensors;
    private Drive drive;
    private DynamicArray vectorData = new DynamicArray();
    private Vector desiredVector = new Vector(0,0);
    private Coordinate endPoint = new Coordinate(0, 0);
    private Coordinate startPoint = new Coordinate(0, 0);
    private boolean initTurning = false;
    private double initAngle = 0;
    private double wallStartPoint = 0;
    private double distBefore = 0;
    private double distCurrent = 0;
    private double curAngle = 0;
    private double newDriveDist = 0;
    private double startDrivePoint = 0;
    private double curDriveDist = 0;
    private double speedLeft = Config.driveSpeed;
    private double speedRight = Config.driveSpeed;
    
    public Autonomous(Sensors sensor, Drive driver)
    {
        sensors = sensor;
        drive = driver;
    }
    
    public void run()
    {
        curDriveDist = startDrivePoint + sensors.getBotDist();
        curAngle = sensors.getGyroTheta();
        distBefore = distCurrent;
        distCurrent = sensors.getUltrasonicDist();
        
        if(objectInFront())
        {
            if(!initTurning)
            {
                initTurning = true;
                wallStartPoint = distCurrent;
                initAngle = curAngle;
                speedLeft = Config.turnSpeed;
                speedRight = Config.turnSpeed;
                
                if(destOnRight(getCurrentPos(vectorData), endPoint))
                    speedRight = -speedRight;

                else 
                    speedLeft = -speedLeft;
            }
            
            if(Math.abs(distCurrent - distBefore) >= Config.minDist)
            {
                newDriveDist = getThirdSide(wallStartPoint, Math.abs(curAngle - initAngle), distCurrent);
            }
                
        }
        
        else
        {
            initTurning = false;
            Coordinate currentPoint = getCurrentPos(vectorData);
            
            if(currentPoint.getX() == endPoint.getY())
            {
                
            }
        }
        
        drive.setSpeed(speedLeft, speedRight);
    }
    
    public double getTotalDisplacement(Coordinate initPoint, DynamicArray vectors)
    {
        double x = initPoint.getX();
        double y = initPoint.getY();
        Coordinate point = null;
        
        for(int i = 0; i < vectors.size(); i++)
        {
            point = ((Vector)vectors.elementAt(i)).getXY();
            x += point.getX();
            y += point.getY();
        }
        
        return MyMath.getDistance(initPoint, new Coordinate(x, y));
    }
    
    public Coordinate getCurrentPos(DynamicArray vectors)
    {
        double x = startPoint.getX();
        double y = startPoint.getY();
        Coordinate returnPoint = new Coordinate(0,0);
        
        for(int i = 0; i < vectors.size(); i++)
        {
            returnPoint = ((Vector)vectors.elementAt(i)).getXY();
            x += returnPoint.getX();
            y += returnPoint.getY();
        }
        
        return returnPoint;
    }
    
    public void setUp()
    {
        endPoint.setCoordinate(Station.getAnalogIn(Config.stAnalogAutoEndX), Station.getAnalogIn(Config.stAnalogAutoEndY));
        startPoint.setCoordinate(Station.getAnalogIn(Config.stAnalogAutoStartX), Station.getAnalogIn(Config.stAnalogAutoStartY));
        desiredVector.setVector(MyMath.getAngle(startPoint, endPoint), MyMath.getDistance(startPoint, endPoint));
    }
    
    public boolean objectInFront()
    {
        if(sensors.getUltrasonicDist() <= (sensors.getRobotVelocity()*Config.distConst + Config.minDist))
            return true;
        
        return false;
    }
    
    public void turn(double angle)
    {
        if(angle > curAngle)
            drive.setSpeed(Config.turnSpeed, -Config.turnSpeed);

        else
            drive.setSpeed(-Config.turnSpeed, Config.turnSpeed);
    }
    
    public boolean onAngle(double desiredAngle)
    {
        return Math.abs(curAngle- desiredAngle) >= Config.angTolerance;
    }
    
    public boolean destOnRight(Coordinate start, Coordinate end)
    {
        double angle = MyMath.getAngle(start, end);
        
        if(angle < (curAngle + 180) && angle > curAngle)
            return true;
        
        return false;
    }
    
    // TODO: FINISH THIS CALCULATION OF THE THRID SIDE GIVEN A SAS TRIANGLE
    public double getThirdSide(double sideOne, double angle, double sideTwo)
    {
        double retVal = 0;
        
        return retVal;
    }
}