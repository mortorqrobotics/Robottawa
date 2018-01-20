package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.RobotMap;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gearbox extends Subsystem {
	
	private MotorModule motorModule;
	private Encoder encoder;
	private DoubleSolenoid solenoid;
	
	final double K_P = 0.001;
	final double K_I = 0;
	final double K_D = 0;
	
	
	public Gearbox(int[] talonPorts, Pair<Integer> encoderPorts, Pair<Integer> solenoidPorts) {
		motorModule = new MotorModule(talonPorts);
		encoder = new Encoder(encoderPorts.first, encoderPorts.last);
		solenoid = new DoubleSolenoid(RobotMap.PCM, solenoidPorts.first, solenoidPorts.last);
	}
	
	public void setSpeed(double speed) {
		motorModule.setSpeed(speed);
	}
	
	public void switchToHighGear() {
		solenoid.set(Value.kForward);
	}

	public void switchToLowGear() {
		solenoid.set(Value.kReverse);
	}
	
	public int getEncoder() {
		return encoder.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

}
