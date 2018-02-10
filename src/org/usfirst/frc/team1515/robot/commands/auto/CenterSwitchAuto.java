package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommandGroup;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.util.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchAuto extends CommandGroup {

	final int OFFSET_DIST = 24; //inches
	final double SPEED = 0.5;
	
	public CenterSwitchAuto(Position platePosition) {
		addSequential(new DriveForward(OFFSET_DIST, SPEED));
		switch (platePosition) {
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
		addSequential(new MoveCommandGroup(FieldMap.FIRST_CENTER_LEFT, true));
		addSequential(new MoveCommandGroup(FieldMap.SECOND_CENTER_LEFT, true));
	}

	private void goToRightSwitch() {
		addSequential(new MoveCommandGroup(FieldMap.FIRST_CENTER_RIGHT, true));
		addSequential(new MoveCommandGroup(FieldMap.SECOND_CENTER_RIGHT, true));
	}
}
