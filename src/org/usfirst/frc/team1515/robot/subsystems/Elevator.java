package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.util.MotorModule;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	MotorModule motors;
	
	private static final double SPEED = 0.3;
	
	public Elevator(int[] talonPorts) {
		motors = new MotorModule(talonPorts);
	}
	
	public void raise() {
		motors.setSpeed(SPEED);
	}
	
	public void lower() {
		motors.setSpeed(-SPEED);
	}
	
	public void stop() {
		motors.stop();
	}

    public void initDefaultCommand() {
    }
}

