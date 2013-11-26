/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author Pedro
 */
public class Ultrasonic extends AnalogChannel 
{
    // Converts mV/mm scale factor from EZ0 datasheet to In/V
    private final double scalar = (1000/.997)/25.4/12; // 0.997mV/mm
    
    public Ultrasonic(int channel)
    {
        super(channel);
    }
    
    public double getDistanceFeet()
    {
        return this.getVoltage()*(scalar);
    }
}
