package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	MotorModule motors;
	DoubleSolenoid solenoid;
	DigitalInput limitSwitch;
	
	private static final double SPEED = 1;
	
	public Intake(int[] talonPorts, Pair<Integer> solenoidChannel, int limitSwitchPort) {
		motors = new MotorModule(talonPorts);
		solenoid = new DoubleSolenoid(solenoidChannel.first, solenoidChannel.last);
		limitSwitch = new DigitalInput(limitSwitchPort);
	}
	
	public void open() {
		solenoid.set(Value.kForward);
	}
	
	public void close() {
		solenoid.set(Value.kReverse);
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

