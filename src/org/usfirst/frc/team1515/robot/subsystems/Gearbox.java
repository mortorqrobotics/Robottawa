package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.Robot;
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

	final double K_P = 0.0;
	final double K_I = 0.0;
	final double K_D = 0.0;
	
	final int MAX_ENCODER_RATE_HIGH = 35000; 
	final int MAX_ENCODER_RATE_LOW = 15000;

	
	private double error;
	private double lastError;
	private double errorSum;
	
	
	private boolean isHighGear = false;
	
	public Gearbox(int[] talonPorts, Pair<Integer> encoderPorts, Pair<Integer> solenoidPorts) {
		motorModule = new MotorModule(talonPorts);
		encoder = new Encoder(encoderPorts.first, encoderPorts.last);
		solenoid = new DoubleSolenoid(RobotMap.PCM, solenoidPorts.first, solenoidPorts.last);

		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(1);
		encoder.setSamplesToAverage(10);
//		encoder.setReverseDirection(true);
		encoder.reset();

		resetPID();
	}
	
	public void setSpeedPID(double input) {
		double measuredSpeed = getEncoder() / (isHighGear ? MAX_ENCODER_RATE_HIGH : MAX_ENCODER_RATE_LOW);
		error = measuredSpeed;
		errorSum *= 0.9;
		double output = ((error * K_P) + (errorSum * K_I) + ((error - lastError) * K_D));
//		setSpeed(input);
		setSpeed(input - output);
		lastError = error;
//		if (Math.abs(output) <= 1 && Math.abs(errorSum) <= 10) {
			errorSum += error;
//		}

		Robot.smartDashboard.putNumber("requested speed", input);
		Robot.smartDashboard.putNumber("measured speed", measuredSpeed);
		Robot.smartDashboard.putNumber("output speed", output);
		Robot.smartDashboard.putBoolean("isHighGear", isHighGear);
		Robot.smartDashboard.putNumber("error", error);
		Robot.smartDashboard.putNumber("errorSum", errorSum);

	}
	
	public void setSpeed(double speed) {
		motorModule.setSpeed(speed);
	}
	
	public void switchToHighGear() {
		System.out.println("high");
		solenoid.set(Value.kReverse);
		isHighGear = true;
	}

	public void switchToLowGear() {
		System.out.println("low");
		solenoid.set(Value.kForward);
		isHighGear = false;
	}
	
	public double getEncoder() {
		return encoder.getRate();
	}
	
	public void resetPID() {
		error = 0;
		lastError = 0;
		errorSum = 0;
	}

	@Override
	protected void initDefaultCommand() {
	}

}
