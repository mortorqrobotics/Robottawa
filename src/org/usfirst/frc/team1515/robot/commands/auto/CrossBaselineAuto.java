package org.usfirst.frc.team1515.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossBaselineAuto extends CommandGroup {

	static final int TICKS = 100;
	static final double SPEED = 0.5;

	public CrossBaselineAuto() {
		addSequential(new DriveForward(TICKS, SPEED);
    }
}
