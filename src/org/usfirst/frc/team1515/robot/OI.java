package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.Climb;
import org.usfirst.frc.team1515.robot.commands.CloseIntake;
import org.usfirst.frc.team1515.robot.commands.IntakeCube;
import org.usfirst.frc.team1515.robot.commands.LowerElevator;
import org.usfirst.frc.team1515.robot.commands.OpenIntake;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.PurgeExchange;
import org.usfirst.frc.team1515.robot.commands.RaiseElevator;
import org.usfirst.frc.team1515.robot.commands.ShiftToHighGear;
import org.usfirst.frc.team1515.robot.commands.ShiftToLowGear;
import org.usfirst.frc.team1515.robot.commands.ToggleIntake;
import org.usfirst.frc.team1515.robot.commands.TogglePID;

public class OI {

	public OI() {
		Controls.SHIFT_TO_HIGH_GEAR.whenPressed(new ShiftToHighGear());
		Controls.SHIFT_TO_LOW_GEAR.whenPressed(new ShiftToLowGear());
		Controls.TOGGLE_PID.whenPressed(new TogglePID());
		
		Controls.INTAKE.whileHeld(new IntakeCube());
		Controls.PURGE.whileHeld(new PurgeCube());
		
		Controls.PURGE_EXCHANGE.whileHeld(new PurgeExchange());
		Controls.TOGGLE_INTAKE.whenPressed(new ToggleIntake());
		
		Controls.RAISE_ELEVATOR.whileHeld(new RaiseElevator());
		Controls.LOWER_ELEVATOR.whileHeld(new LowerElevator());
		Controls.CLIMB.whileHeld(new Climb());
	}
}
