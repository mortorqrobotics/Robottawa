package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.util.MotorModule;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	MotorModule motors;
	DigitalInput limitSwitchTop;
	DigitalInput limitSwitchBottom;
	
	private double speed;
	
	public Elevator(int[] talonPorts, int limitSwitchPortTop, int limitSwitchPortBottom) {
		motors = new MotorModule(talonPorts);
		limitSwitchTop = new DigitalInput(limitSwitchPortTop);
		limitSwitchBottom = new DigitalInput(limitSwitchPortBottom);
	}
	
	public void raise() {
		motors.setSpeed(-speed);
	}
	
	public void lower() {
		motors.setSpeed(speed);
	}
	
	public void stop() {
		motors.stop();
	}
	
	public boolean isLimitSwitchTopPressed() {
		return !limitSwitchTop.get();
	}
	
	public boolean isLimitSwitchBottomPressed() {
		return !limitSwitchBottom.get();
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}


    public void initDefaultCommand() {
    }
}

