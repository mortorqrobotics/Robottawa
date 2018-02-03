package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.util.Direction;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideSwitchAuto extends CommandGroup {

	static final int FORWARD_DIST_TICKS = 100;
	static final int SIDE_DIST_TICKS = 100;

	static final int FORWARD_DIST_SPEED = 0.5;
	static final int SIDE_DIST_SPEED = 0.5;

	static final double ANGLE = 90;

	public SideSwitchAuto(Direction platePosition) {
		addSequential(DriveForward(FORWARD_DIST_TICKS, FORWARD_DIST_SPEED));
		addSequential(TurnAngle(platePosition == Direction.LEFT ? ANGLE : -ANGLE));
		addSequential(DriveForward(SIDE_DIST_TICKS, SIDE_DIST_SPEED));
    }
}
