package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.util.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class TurnAnglePID extends Command {

	PIDController pidController;

	static final double K_P = 0.007;
	static final double K_I = 0.000000000000001;
	static final double K_D = 0.0;

	double startAngle;
	double target;

	public TurnAnglePID(double target, double timeout) {
		requires(Robot.driveTrain);
		this.target = target;
		setTimeout(timeout);
	}

	@Override
	protected void initialize() {
		startAngle = Robot.gyro.getAngle();
		pidController = new PIDController(K_P, K_I, K_D);
	}

	@Override
	protected boolean isFinished() {
		double measuredAngle = Robot.gyro.getAngle() - startAngle;
		double output = pidController.getOutput(target, measuredAngle);
		Robot.driveTrain.setSpeeds(output, -output);
		pidController.printToSmartDashboard("angle");

		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}

