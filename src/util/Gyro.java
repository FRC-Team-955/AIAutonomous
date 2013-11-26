/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;



/**
 *
 * @author Pedro
 */
public class Gyro extends edu.wpi.first.wpilibj.Gyro {
    public Gyro(int channel) {
        super(channel);
    }
    
    public double getAngle() {
        double rad = super.getAngle()*Math.PI/180;
        return (Math.floor(rad*10 + .5)/10);
    }
    public double getAbsAngle() {
        return this.getAngle()%(2*Math.PI);
    }
}
