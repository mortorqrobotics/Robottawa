package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.CloseIntake;
import org.usfirst.frc.team1515.robot.commands.IntakeCube;
import org.usfirst.frc.team1515.robot.commands.LockIntake;
import org.usfirst.frc.team1515.robot.commands.LowerElevator;
import org.usfirst.frc.team1515.robot.commands.OpenIntake;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.RaiseElevator;
import org.usfirst.frc.team1515.robot.commands.ReleaseIntake;
import org.usfirst.frc.team1515.robot.commands.ShiftToHighGear;
import org.usfirst.frc.team1515.robot.commands.ShiftToLowGear;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAngle;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	

	public OI() {
		Controls.SHIFT_TO_HIGH_GEAR.whenPressed(new ShiftToHighGear());
		Controls.SHIFT_TO_LOW_GEAR.whenPressed(new ShiftToLowGear());
		
//		Controls.TOGGLE_INTAKE.whenActive(new OpenIntake());
//		Controls.TOGGLE_INTAKE.whenInactive(new CloseIntake());
		
		Controls.LOCK_INTAKE.whenPressed(new LockIntake());
		Controls.RELEASE_INTAKE.whenPressed(new ReleaseIntake());
		
		Controls.INTAKE.whileHeld(new IntakeCube());
		Controls.PURGE.whileHeld(new PurgeCube());
		
		Controls.RAISE_ELEVATOR.whileHeld(new RaiseElevator());
		Controls.LOWER_ELEVATOR.whileHeld(new LowerElevator());
		
//		new JoystickButton(Robot.driveStick, 1).whenPressed(new TurnAnglePID(90, 3));;
//		new JoystickButton(Robot.driveStick, 6).whenPressed(new TurnAngle(90));;
	}
}
