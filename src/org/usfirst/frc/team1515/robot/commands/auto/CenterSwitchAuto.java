package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.util.Direction;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchAuto extends CommandGroup {

	static final int FIRST_DIST_TICKS = 100;
	static final int SECOND_DIST_TICKS = 100;

	static final double FIRST_DIST_SPEED = 0.5;
	static final double SECOND_DIST_SPEED = 0.5;

	static final double ANGLE = 60;

	public CenterSwitchAuto(Direction platePosition) {
//		addSequential(DriveForward(FORWARD_DIST_TICKS, FORWARD_DIST_SPEED));
//		addSequential(TurnAngle(platePosition == Direction.LEFT ? ANGLE : -ANGLE));
//		addSequential(DriveForward(SIDE_DIST_TICKS, SIDE_DIST_SPEED));
    }

}
