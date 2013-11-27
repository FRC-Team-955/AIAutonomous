/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author RaiderPC
 */
public class MyGyro extends Gyro {
	public MyGyro(int channel) {
		super(channel);
	}
	public double getAngle() {
		double rad = this.getAngle()*Math.PI/180;
		return (Math.floor(rad*10 + .5)/10)%(2*Math.PI);
	}
}
