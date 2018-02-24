package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCube extends Command {

    public IntakeCube() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.close();
    }

    protected void execute() {
    	Robot.intake.intake();
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
