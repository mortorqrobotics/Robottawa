package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PurgeExchange extends Command {

    public PurgeExchange() {
    	requires(Robot.intake);
    }
    
    public PurgeExchange(double timeout) {
    	this();
    	setTimeout(timeout);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.purgeExchange();
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
