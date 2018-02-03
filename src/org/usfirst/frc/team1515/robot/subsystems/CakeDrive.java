package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.Controls;
import org.usfirst.frc.team1515.robot.commands.JoystickDrive;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CakeDrive extends Subsystem {
	
	private Gearbox leftGearbox;
	private Gearbox rightGearbox;
	
	private static final double ROTATE_SIDE = 1.0;
	private static final double ROTATE_CORNER = 0.25;

	private static final double DEADBAND_FORWARD = 0.15;
	private static final double DEADBAND_TWIST = 0.05;

	// change sign to change direction
	final int factor = 1; 
	
	public CakeDrive(int[] leftTalonPorts, int[] rightTalonPorts, 
		Pair<Integer> leftEncoderPorts, Pair<Integer> rightEncoderPorts,
		Pair<Integer> leftSolenoidPorts, Pair<Integer> rightSolenoidPorts
	) {
		leftGearbox = new Gearbox(leftTalonPorts, leftEncoderPorts, leftSolenoidPorts);
		rightGearbox = new Gearbox(rightTalonPorts, rightEncoderPorts, rightSolenoidPorts);
	}
	
	public void setSpeed(double speed) {
//		leftGearbox.setSpeedPID(speed * factor);
//		rightGearbox.setSpeedPID(-speed * factor);
		leftGearbox.setSpeed(speed * factor);
		rightGearbox.setSpeed(-speed * factor);
	}
	
	public void setSpeeds(double leftSpeed, double rightSpeed) {
//		leftGearbox.setSpeedPID(leftSpeed * factor);
//		rightGearbox.setSpeedPID(-rightSpeed * factor);
		leftGearbox.setSpeed(leftSpeed * factor);
		rightGearbox.setSpeed(-rightSpeed * factor);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	public void drive() {
		double forward = Robot.driveStick.getRawAxis(Controls.Y_AXIS);
		double twist = Robot.driveStick.getRawAxis(Controls.TWIST);
		double throttle = Robot.driveStick.getRawAxis(Controls.THROTTLE);
		double turnSpeed = Robot.driveStick.getRawAxis(Controls.TURN_SPEED);
		
		forward = Math.abs(forward) > DEADBAND_FORWARD ? forward : 0;
		twist = Math.abs(twist) > DEADBAND_TWIST ? twist : 0;
		
		turnSpeed = (1 + turnSpeed)/2;
		throttle = (throttle - 1)/2;
		forward *= throttle;
		twist *= turnSpeed;
		
		double y = Math.abs(forward);
		double x = Math.abs(twist);
		double a = ROTATE_SIDE;
		double b = ROTATE_CORNER;
		
		double left = a * x + y * (1 - a * x);
		double right = y * (1 + (a + b - 1) * x) - a * x;
		if (forward < 0) {
			left *= -1;
			right *= -1;
			twist *= -1;
		}
		if (twist > 0) {
			double temp = left;
			left = right;
			right = temp;
		}
		
		Robot.smartDashboard.putNumber("left encoder", leftGearbox.getEncoder());
		Robot.smartDashboard.putNumber("right encoder", rightGearbox.getEncoder());
		
//		setSpeeds(0.2, 0.2);
		leftGearbox.setSpeed(0.5);
//		rightGearbox.setSpeedPID(0.5);

		
		leftGearbox.printToSmartDashboard("left");
//		rightGearbox.printToSmartDashboard("right");

		
	}
	
	public double getLeftEncoder() {
		return leftGearbox.getEncoder();
	}
	
	public double getRightEncoder() {
		return rightGearbox.getEncoder();
	}
	
	public void switchToHighGear() {
		leftGearbox.switchToHighGear();
		rightGearbox.switchToHighGear();
	}

	public void switchToLowGear() {
		leftGearbox.switchToLowGear();
		rightGearbox.switchToLowGear();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}

}
