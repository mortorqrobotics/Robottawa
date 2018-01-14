package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.Controls;
import org.usfirst.frc.team1515.robot.commands.JoystickDrive;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private MotorModule mLeftMotors;
	private MotorModule mRightMotors;
	
	private Encoder mLeftEncoder;
	private Encoder mRightEncoder;

	private static final double ROTATE_SIDE = 1.0;
	private static final double ROTATE_CORNER = 0.25;
	private static final double DEAD_BAND = 0.15;

	// change sign to change direction
	final int factor = 1; 
	
	public DriveTrain(int[] leftMotorPorts, int[] rightMotorPorts) {
		mLeftMotors = new MotorModule(leftMotorPorts);
		mRightMotors = new MotorModule(rightMotorPorts);
	}
	
	public DriveTrain(int[] leftMotorPorts, int[] rightMotorPorts, Pair<Integer> mLeftEncoderPorts, Pair<Integer> mRightEncoderPorts) {
		mLeftMotors = new MotorModule(leftMotorPorts);
		mRightMotors = new MotorModule(rightMotorPorts);
		mLeftEncoder = new Encoder(mLeftEncoderPorts.first, mLeftEncoderPorts.last);
		mRightEncoder = new Encoder(mRightEncoderPorts.first, mRightEncoderPorts.last);
	}
	
	public void setSpeed(double speed) {
		mLeftMotors.setSpeed(speed * factor);
		mRightMotors.setSpeed(-speed * factor);
	}
	
	public void setSpeeds(double leftSpeed, double rightSpeed) {
		mLeftMotors.setSpeed(leftSpeed * factor);
		mRightMotors.setSpeed(-rightSpeed * factor);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	public void drive() {
		double tilt = Robot.driveStick.getRawAxis(Controls.X_AXIS);
		double forward = Robot.driveStick.getRawAxis(Controls.Y_AXIS);
		double twist = Robot.driveStick.getRawAxis(Controls.TWIST);
		double throttle = Robot.driveStick.getRawAxis(Controls.THROTTLE);
		
		tilt *= throttle;
		forward *= throttle;
		twist *= throttle;
		
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
		
		setSpeeds(left, right);
		
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}

}
