package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAngle;
import org.usfirst.frc.team1515.robot.util.Direction;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideSwitchAuto extends CommandGroup {

	static final int FORWARD_DIST_TICKS = 100;
	static final int SIDE_DIST_TICKS = 100;
	
	static final double FORWARD_DIST_SPEED = 0.5;
	static final double SIDE_DIST_SPEED = 0.5;

	static final double ANGLE = 90;

	public SideSwitchAuto(Direction platePosition) {
		addSequential(new DriveForward(FORWARD_DIST_TICKS, FORWARD_DIST_SPEED));
//		addSequential(new TurnAngle(platePosition == Direction.LEFT ? ANGLE : -ANGLE));
		addSequential(new DriveForward(SIDE_DIST_TICKS, SIDE_DIST_SPEED));
    }
}
