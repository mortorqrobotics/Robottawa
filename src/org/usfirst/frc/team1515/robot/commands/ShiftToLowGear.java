package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftToLowGear extends Command {
	
	public ShiftToLowGear() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.switchToLowGear();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
