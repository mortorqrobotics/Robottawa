package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossBaselineAuto extends CommandGroup {

	static final int TICKS = 100;
	static final double SPEED = 0.5;

	public CrossBaselineAuto() {
		addSequential(new DriveForward(TICKS, SPEED));
		addSequential(new DriveForward(TICKS, SPEED));
	}
}
