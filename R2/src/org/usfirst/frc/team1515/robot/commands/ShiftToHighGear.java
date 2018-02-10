package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftToHighGear extends Command {
	
	public ShiftToHighGear() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.switchToHighGear();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
