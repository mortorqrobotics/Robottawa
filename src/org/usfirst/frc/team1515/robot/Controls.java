package org.usfirst.frc.team1515.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {
	
	public static final int DRIVE_STICK = 0;
	public static final int MANIPULATOR_STICK = 1;
	
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;
	public static final int THROTTLE = 2;
	public static final int TWIST = 5;
	public static final int TURN_SPEED = 6;

	public static final Button SHIFT_TO_HIGH_GEAR = new JoystickButton(Robot.driveStick, 3);
	public static final Button SHIFT_TO_LOW_GEAR = new JoystickButton(Robot.driveStick, 4);
	
	public static final Button INTAKE = new JoystickButton(Robot.manipStick, 5);
	public static final Button PURGE = new JoystickButton(Robot.manipStick, 3);
	
	public static final Button RAISE_ELEVATOR = new JoystickButton(Robot.manipStick, 6);
	public static final Button LOWER_ELEVATOR = new JoystickButton(Robot.manipStick, 4);
}
