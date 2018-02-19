package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseElevator extends Command {

    public RaiseElevator() {
    	requires(Robot.elevator);
    }

    protected void execute() {
    	Robot.elevator.raise();
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
