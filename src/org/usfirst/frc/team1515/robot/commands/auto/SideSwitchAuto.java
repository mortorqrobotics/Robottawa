package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.Direction;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideSwitchAuto extends CommandGroup {

	static final double FORWARD_DIST = 10; // inches
	static final double SIDE_DIST= 5;
	
	static final double FORWARD_DIST_SPEED = 0.5;
	static final double SIDE_DIST_SPEED = 0.5;

	static final double ANGLE = 90;
	static final double ANGLE_TIMEOUT = 3;

	public SideSwitchAuto(Direction platePosition) {
		addSequential(new DriveForward(FORWARD_DIST, FORWARD_DIST_SPEED));
		addSequential(new TurnAnglePID(platePosition == Direction.LEFT ? ANGLE : -ANGLE, ANGLE_TIMEOUT));
		addSequential(new DriveForward(SIDE_DIST, SIDE_DIST_SPEED));
    }
}
