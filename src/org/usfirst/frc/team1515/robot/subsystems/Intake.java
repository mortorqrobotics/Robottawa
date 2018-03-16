package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.RobotMap;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	MotorModule motors;
	DoubleSolenoid solenoid;
	
	private static final double SPEED = -0.5;
	private boolean isOpen = true;
	
	public Intake(int[] talonPorts, Pair<Integer> solenoidChannels) {
		motors = new MotorModule(talonPorts);
		solenoid = new DoubleSolenoid(RobotMap.PCM, solenoidChannels.first, solenoidChannels.last);
	}
	
	public void open() {
		solenoid.set(Value.kReverse);
		isOpen = true;
	}
	
	public void close() {
		solenoid.set(Value.kForward);
		isOpen = false;
	}
	
	public void toggle() {
		if(isOpen) {
			close();
		} else {
			open();
		}
	}
	
	public void intake() {
		motors.setAlternatingSpeed(SPEED);
	}
	
	public void purge() {
		motors.setAlternatingSpeed(-SPEED);
	}
	
	public void stop() {
		motors.stop();
	}

    public void initDefaultCommand() {
    }
}

