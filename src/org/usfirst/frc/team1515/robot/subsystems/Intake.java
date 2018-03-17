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
	
	private static final double SPEED = 0.7;
	private static final double PURGE_SPEED = -0.4;
	private static final double PURGE_SPEED_EXCHANGE = -0.8;
	private boolean isOpen = false;
	
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
		motors.setAlternatingSpeed(PURGE_SPEED);
	}
	
	public void purgeExchange() {
		motors.setAlternatingSpeed(PURGE_SPEED_EXCHANGE);
	}
	
	public void stop() {
		motors.stop();
	}

    public void initDefaultCommand() {
    }
}
