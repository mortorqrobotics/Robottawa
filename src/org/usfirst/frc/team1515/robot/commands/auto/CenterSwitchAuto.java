package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAngle;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchAuto extends CommandGroup {

	static final int FIRST_DIST_TICKS = 100;
	static final int SECOND_DIST_TICKS = 100;

	static final double FIRST_DIST_SPEED = 0.5;
	static final double SECOND_DIST_SPEED = 0.5;

	static final double ANGLE = 60;
	static final double ANGLE_TIMEOUT = 3;

	public CenterSwitchAuto(Position platePosition) {
		addSequential(new DriveForward(FIRST_DIST, FIRST_DIST_SPEED));
		addSequential(new TurnAnglePID(platePosition == Position.LEFT ? ANGLE : -ANGLE, ANGLE_TIMEOUT));
		addSequential(new DriveForward(SECOND_DIST, SECOND_DIST_SPEED));
		addSequential(new TurnAnglePID(platePosition == Position.LEFT ? -ANGLE : ANGLE, ANGLE_TIMEOUT));
	}

}
