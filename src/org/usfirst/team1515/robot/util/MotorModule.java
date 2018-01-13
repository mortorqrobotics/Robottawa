package org.usfirst.team1515.robot.util;

import com.ctre.CANTalon;;

public class MotorModule {
	
	CANTalon[] talons;
	
	public MotorModule(int... motorPorts) {
		talons = new CANTalon[motorPorts.length];
		for (int i = 0; i < motorPorts.length; i++) {
			talons[i] = new CANTalon(motorPorts[i]);
			talons[i].setSafetyEnabled(false);
		}
	}
	
	public void setSpeed(double speed) {
		for (CANTalon talon : talons) {
			talon.set(speed);
		}
	}
	
	public void stop() {
		for (CANTalon talon : talons) {
			talon.set(0);
		}
	}

}
