package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {

    public Climb() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.setClimbSpeed();
    }

    protected void execute() {
    	Robot.elevator.lower();
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }
    protected void end() {
    	Robot.elevator.stop();
    }

    protected void interrupted() {
    	end();
    }
}
