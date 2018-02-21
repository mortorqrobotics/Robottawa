package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1515.robot.util.Position;

public class CenterAuto extends CommandGroup {
	
	public CenterAuto() {
		PlaneUtil.setCurrentLoc(FieldMap.START_CENTER);

		addSequential(new MoveCommand(FieldMap.CENTER_OFFSET));
		
		switch (Robot.switchPosition) {
		case LEFT:
			goToLeftSwitch();
			break;
		case RIGHT:
			goToRightSwitch();
			break;
		}
		addSequential(new PurgeCube());
	}

	private void goToLeftSwitch() {
		addSequential(new MoveCommand(FieldMap.CENTER_LEFT_MIDPOINT, false));
		addSequential(new MoveCommand(FieldMap.CENTER_LEFT_SWITCH));
	}

	private void goToRightSwitch() {
		addSequential(new MoveCommand(FieldMap.CENTER_RIGHT_MIDPOINT, false));
		addSequential(new MoveCommand(FieldMap.CENTER_RIGHT_SWITCH));
	}
}
