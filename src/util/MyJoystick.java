/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Merfoo
 */
public class MyJoystick extends Joystick
{
    private boolean[] buttonLast = null;
    private boolean[] buttonSwitch = null;
    private final double dpadTolerance = 0.2;
    private final int chanVert = 6;
    private final int chanHorz = 5;
    private final int amountOfButtons;
    
    public MyJoystick(int portOne, int buttonsOnJoy)
    {
        super(portOne);
        amountOfButtons = buttonsOnJoy;
        buttonLast = new boolean[amountOfButtons];
        buttonSwitch = new boolean[amountOfButtons];
        
        for(int index = 0; index < amountOfButtons; index++)
            buttonLast[index] = buttonSwitch[index] = false;
    }
    
    public boolean gotPressed(int chan)
    {
        boolean output = (!buttonLast[chan-1] && getRawButton(chan));
        buttonLast[chan-1] = getRawButton(chan);
        return output;
    }
    
    public boolean getSwitch(int chan)
    {
        return buttonSwitch[chan-1];
    }
    
    public void flipSwitch(int chan)
    {
        setSwitch(chan, !getSwitch(chan));
    }
    
    public void setSwitch(int chan, boolean newVal)
    {
        buttonSwitch[chan-1] = newVal;
    }
    
    /**
     * Gets the value of the dPad up
     * @return 
     */
    public boolean getDpadUp()
    {
        return (getRawAxis(chanVert) > dpadTolerance);
    }
     
    /**
     * Gets the value of the dPad right
     * @return 
     */
    public boolean getDpadRight()
    {
        return (getRawAxis(chanHorz) > dpadTolerance);
    }
    
    /**
     * Gets the value of the dPad down
     * @return 
     */
    public boolean getDpadDown()
    {
        return (getRawAxis(chanVert) < -dpadTolerance);
    }
        
    /**
     * Gets the value of the dPad left
     * @return 
     */
    public boolean getDpadLeft()
    {
        return (getRawAxis(chanHorz) < -dpadTolerance);
    }
}
