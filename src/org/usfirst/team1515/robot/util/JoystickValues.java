package org.usfirst.team1515.robot.util;

public class JoystickValues {
	
	private double x;
	private double y;
	private double z;
	
	private double throttle;
	
	public JoystickValues(double x, double y, double z, double throttle) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.throttle = throttle;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getThrottle() {
		return throttle;
	}

}
