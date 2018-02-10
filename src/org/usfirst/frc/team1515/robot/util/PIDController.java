package org.usfirst.frc.team1515.robot.util;

import org.usfirst.frc.team1515.robot.Robot;

public class PIDController {
	
	private final double K_P;
	private final double K_I;
	private final double K_D;
	
	double p_term;
	double i_term;
	double d_term;
	
	double error;
	double lastError;
	double errorSum;
	
	double target;
	double actual;
	double output;
	
	public PIDController(double K_P, double K_I, double K_D) {
		this.K_P = K_P;
		this.K_I = K_I;
		this.K_D = K_D;
	}
	
	public double getOutput(double target, double actual) {
		this.target = target;
		this.actual = actual;

		error = target - actual;
		
		p_term = error * K_P;
		
		errorSum += error;
		i_term = errorSum * K_I;
		
		d_term = (error - lastError);
		d_term *= K_D;
		
		lastError = error;
		output = p_term + i_term + d_term;
		
		return output;
	}
	
	public void reset() {
		 p_term = 0;
		 i_term = 0;
		 d_term = 0;

		 error = 0;
		 lastError = 0;
		 errorSum = 0;
	}
	
	@SuppressWarnings("static-access")
	public void printToSmartDashboard(String identifier) {
		Robot.smartDashboard.putNumber(identifier + " target", target);
		Robot.smartDashboard.putNumber(identifier + " measured", actual);
		Robot.smartDashboard.putNumber(identifier + " output", output);
		
		Robot.smartDashboard.putNumber(identifier + " error", error);
		Robot.smartDashboard.putNumber(identifier + " p_term", p_term);
		Robot.smartDashboard.putNumber(identifier + " i_term", i_term);
		Robot.smartDashboard.putNumber(identifier + " d_term", d_term);
	}

}
