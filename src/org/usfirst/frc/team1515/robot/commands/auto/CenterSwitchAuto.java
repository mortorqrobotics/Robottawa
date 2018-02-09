package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAngle;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.Direction;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchAuto extends CommandGroup {

	static final double FIRST_DIST = 10; // inches
	static final double SECOND_DIST = 10;

	static final double FIRST_DIST_SPEED = 0.5;
	static final double SECOND_DIST_SPEED = 0.5;

	static final double ANGLE = 60;
	static final double ANGLE_TIMEOUT = 3;

	public CenterSwitchAuto(Direction platePosition) {
		addSequential(new DriveForward(FIRST_DIST, FIRST_DIST_SPEED));
		addSequential(new TurnAnglePID(platePosition == Direction.LEFT ? ANGLE : -ANGLE, ANGLE_TIMEOUT));
		addSequential(new DriveForward(SECOND_DIST, SECOND_DIST_SPEED));
		addSequential(new TurnAnglePID(platePosition == Direction.LEFT ? -ANGLE : ANGLE, ANGLE_TIMEOUT));
	}

}
