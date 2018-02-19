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
	DoubleSolenoid grabSolenoid;
	DoubleSolenoid liftSolenoid;
	DigitalInput limitSwitch;
	
	private static final double SPEED = 1;
	
	public Intake(int[] talonPorts, Pair<Integer> grabSolenoidChannels, Pair<Integer> liftSolenoidChannels, int limitSwitchPort) {
		motors = new MotorModule(talonPorts);
		grabSolenoid = new DoubleSolenoid(RobotMap.PCM, grabSolenoidChannels.first, grabSolenoidChannels.last);
		liftSolenoid = new DoubleSolenoid(RobotMap.PCM, liftSolenoidChannels.first, liftSolenoidChannels.last);
		limitSwitch = new DigitalInput(limitSwitchPort);
	}
	
	public void open() {
		grabSolenoid.set(Value.kForward);
	}
	
	public void close() {
		grabSolenoid.set(Value.kReverse);
	}
	
	public void lock() {
		liftSolenoid.set(Value.kForward);
	}
	
	public void release() {
		liftSolenoid.set(Value.kReverse);
	}
	
	public void intake() {
		motors.setSpeed(SPEED);
	}
	
	public void purge() {
		motors.setSpeed(-SPEED);
	}
	
	public void stop() {
		motors.stop();
	}
	
	public boolean isLimitSwitchPressed() {
		return limitSwitch.get();
	}

    public void initDefaultCommand() {
    }
}

