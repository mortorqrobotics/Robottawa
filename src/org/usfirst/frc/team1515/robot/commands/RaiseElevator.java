package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseElevator extends Command {
	
    public RaiseElevator() {
    	requires(Robot.elevator);
    }
    
    public RaiseElevator(double timeout) {
    	this();
    	setTimeout(timeout);
    }

    public void initialize() {
    	Robot.elevator.setMinSpeed();
    }

    protected void execute() {
    	Robot.elevator.raise();
    	Robot.elevator.incrementSpeed();
    }

    protected boolean isFinished() {
        return isTimedOut() || Robot.elevator.isLimitSwitchTopPressed();
    }

    protected void end() {
    	Robot.elevator.stop();
    }

    protected void interrupted() {
    	end();
    }
}
