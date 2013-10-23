/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auto;

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
    private DynamicArray vectorData;
    private Coordinate destination;
    private Coordinate startPoint;
    private final double minDist = 5.0;
    private final double distConst = 2;
    private double newAngle;
    private boolean turnMode = false;
    
    public Autonomous(Sensors sensor)
    {
        vectorData = new DynamicArray();
        destination = new Coordinate(0, 0);
        sensors = sensor;
    }
    
    public void run()
    {
        
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
    
    public void setEndPoint()
    {
        destination.setCoordinate(Station.getAnalogIn(Config.stAnalogAutoEndX), Station.getAnalogIn(Config.stAnalogAutoEndY));
    }
    
    public void setStartPoint()
    {
        destination.setCoordinate(Station.getAnalogIn(Config.stAnalogAutoStartX), Station.getAnalogIn(Config.stAnalogAutoStartY));
    }
    
    public boolean objectInFront()
    {
        if(sensors.getUltrasonicDist() <= (sensors.getRobotVelocity()*distConst + minDist))
            return true;
        
        return false;
    }
}