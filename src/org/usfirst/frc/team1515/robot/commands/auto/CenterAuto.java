package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.util.Position;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterAuto extends CommandGroup {

	final int OFFSET_DIST = 24; //inches
	final double SPEED = 0.5;
	
	public CenterAuto() {
		addSequential(new DriveForward(OFFSET_DIST, SPEED));
		PlaneUtil.setCurrentLoc(FieldMap.START_CENTER);
		
		switch (Robot.alliancePlatePosition) {
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
		addSequential(new MoveCommand(FieldMap.FIRST_CENTER_LEFT, true));
		addSequential(new MoveCommand(FieldMap.SECOND_CENTER_LEFT));
	}

	private void goToRightSwitch() {
		addSequential(new MoveCommand(FieldMap.FIRST_CENTER_RIGHT, true));
		addSequential(new MoveCommand(FieldMap.SECOND_CENTER_RIGHT));
	}
}
