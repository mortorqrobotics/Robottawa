package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CloseIntake extends Command {

	public CloseIntake() {
    	requires(Robot.intake);
    }
    
    @Override
    protected void initialize() {
    	Robot.intake.close();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}

 