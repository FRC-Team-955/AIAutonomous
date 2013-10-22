/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author Merfoo
 */
public class Station 
{
    /**
     * Gets the button status from the driverstation, 1 - 8 available.
     * @param iChan
     * @return 
     */
    public static boolean getDigitalIn(int iChan)
    {
        return DriverStation.getInstance().getDigitalIn(iChan);
    }
    
    public static double getAnalogIn(int channel)
    {
        return DriverStation.getInstance().getAnalogIn(channel);
    }
    /**
     * Prints specified message to the driver station on the corresponding line
     * 1-6 are available.
     */
    public static void print(int iLine, String sMessage)
    {
        switch(iLine)
        {
            case 1:
            {
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "                   ");
                DriverStationLCD.getInstance().updateLCD(); 
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, sMessage);
                break;
            }
            
            case 2:
            {
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "                   ");
                DriverStationLCD.getInstance().updateLCD(); 
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, sMessage);
                break;
            }
                
            case 3:
            {
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "                   ");
                DriverStationLCD.getInstance().updateLCD(); 
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, sMessage);
                break;
            }
                
            case 4:
            {
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser4, 1, "                   ");
                DriverStationLCD.getInstance().updateLCD(); 
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser4, 1, sMessage);
                break;
            }
                
            case 5:
            {
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, "                   ");
                DriverStationLCD.getInstance().updateLCD(); 
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, sMessage);
                break;
            }
                
            case 6:
            {
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser6, 1, "                   ");
                DriverStationLCD.getInstance().updateLCD(); 
                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser6, 1, sMessage);
                break;
            }
        }
        
        DriverStationLCD.getInstance().updateLCD(); 
    }
}
