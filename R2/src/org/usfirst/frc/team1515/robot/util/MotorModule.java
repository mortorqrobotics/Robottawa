package org.usfirst.frc.team1515.robot.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MotorModule {
	
	TalonSRX[] talons;
	
	public MotorModule(int... talonPorts) {
		talons = new TalonSRX[talonPorts.length];
		for (int i = 0; i < talonPorts.length; i++) {
			talons[i] = new TalonSRX(talonPorts[i]);
		}
	}
	
	public void setSpeed(double speed) {
		for (TalonSRX talon : talons) {
			talon.set(ControlMode.PercentOutput, speed);
		}
	}
	
	public void stop() {
		for (TalonSRX talon : talons) {
			talon.set(ControlMode.PercentOutput, 0);
		}
	}

}
