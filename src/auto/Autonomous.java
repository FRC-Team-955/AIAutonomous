/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auto;

import util.Config;
import util.DynamicArray;
import util.Vector;
import util.Coordinate;

/**
 *
 * @author Merfoo
 */
public class Autonomous 
{
    private DynamicArray vectorData;
    
    public Autonomous()
    {
        vectorData = new DynamicArray();
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
        
        return Config.getDistance(initPoint, new Coordinate(x, y));
    }
}