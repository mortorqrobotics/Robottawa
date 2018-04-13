package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Controls;
import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        return isTimedOut() || (!Controls.ELEVATOR_OVERRIDE.get() && Robot.elevator.isLimitSwitchTopPressed());
    }

    protected void end() {
    	Robot.elevator.stop();
    }

    protected void interrupted() {
    	end();
    }
}
