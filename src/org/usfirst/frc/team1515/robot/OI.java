package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.ShiftToHighGear;
import org.usfirst.frc.team1515.robot.commands.ShiftToLowGear;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAngle;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	

	public OI() {
		Controls.SHIFT_TO_HIGH_GEAR.whenPressed(new ShiftToHighGear());
		Controls.SHIFT_TO_LOW_GEAR.whenPressed(new ShiftToLowGear());
		new JoystickButton(Robot.driveStick, 1).whenPressed(new TurnAngle(90, 5));;
	}
}
