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

	final double K_P = 2.5;
	final double K_I = 2.0;
	final double K_D = 0.0;
	
	final int MAX_ENCODER_RATE_HIGH = 20000; 
	final int MAX_ENCODER_RATE_LOW = 15000;

	double p_term;
	double i_term;
	double d_term;
	
	double measuredSpeed;
	double error;
	double lastError;
	double output;
	double errorSum;
	
	public Gearbox(int[] talonPorts, Pair<Integer> encoderPorts) {
		motorModule = new MotorModule(talonPorts);
		encoder = new Encoder(encoderPorts.first, encoderPorts.last);

		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(1);
		encoder.setSamplesToAverage(10);
//		encoder.setReverseDirection(true);
		encoder.reset();

		resetPID();
	}
	
	@SuppressWarnings("static-access")
	public void setSpeedPID(double input) {
		measuredSpeed = getEncoder().getRate() / (Robot.driveTrain.isHighGear ? MAX_ENCODER_RATE_HIGH : MAX_ENCODER_RATE_LOW);
		error = input - measuredSpeed;
		
		p_term = error * K_P;
		
		errorSum += error;
		i_term = errorSum * K_I;
		
		d_term = (error - lastError);
		d_term *= K_D;
		
		output = (p_term + i_term + d_term);
		setSpeed(output);
		lastError = error;
		
	}
	
	public void setSpeed(double speed) {
		motorModule.setSpeed(speed);
	}
	
	public Encoder getEncoder() {
		return encoder;
	}
	
	public void resetEncoder() {
		encoder.reset();
	}
	
	public void resetPID() {
		error = 0;
		
		p_term = 0;
		i_term = 0;
		d_term = 0;
	}

	@SuppressWarnings("static-access")
	public void printToSmartDashboard(String side) {
		Robot.smartDashboard.putNumber(side + " measured speed", measuredSpeed);
		Robot.smartDashboard.putNumber(side + " output speed", output);
		
		Robot.smartDashboard.putNumber(side + " error", error);
		Robot.smartDashboard.putNumber(side + " p_term", p_term);
		Robot.smartDashboard.putNumber(side + " i_term", i_term);
		Robot.smartDashboard.putNumber(side + " d_term", d_term);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
