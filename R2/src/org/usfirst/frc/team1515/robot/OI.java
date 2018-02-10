package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.ShiftToHighGear;
import org.usfirst.frc.team1515.robot.commands.ShiftToLowGear;

public class OI {
	

	public OI() {
		Controls.SHIFT_TO_HIGH_GEAR.whenPressed(new ShiftToHighGear());
		Controls.SHIFT_TO_LOW_GEAR.whenPressed(new ShiftToLowGear());
	}
}
