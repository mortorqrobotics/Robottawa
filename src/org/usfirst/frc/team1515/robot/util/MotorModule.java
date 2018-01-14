package org.usfirst.frc.team1515.robot.util;

import com.ctre.CANTalon;;

public class MotorModule {
	
	CANTalon[] talons;
	
	public MotorModule(int... talonPorts) {
		talons = new CANTalon[talonPorts.length];
		for (int i = 0; i < talonPorts.length; i++) {
			talons[i] = new CANTalon(talonPorts[i]);
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
