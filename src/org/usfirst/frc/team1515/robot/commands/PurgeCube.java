package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PurgeCube extends Command {

    public PurgeCube() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.open();
    }

    protected void execute() {
    	Robot.intake.purge();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.intake.stop();
    }

    protected void interrupted() {
    	end();
    }
}
