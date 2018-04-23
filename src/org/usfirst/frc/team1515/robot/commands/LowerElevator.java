package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Controls;
import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerElevator extends Command {

	public LowerElevator() {
    	requires(Robot.elevator);
    }
	
	public LowerElevator(double timeout) {
		this();
		setTimeout(timeout);
	}
	
	protected void initialize() {
		Robot.elevator.setMaxSpeedDown();
	}

    protected void execute() {
    	Robot.elevator.lower();
    }

    protected boolean isFinished() {
        return isTimedOut() || (!Controls.ELEVATOR_OVERRIDE.get() && Robot.elevator.isLimitSwitchBottomPressed());
    }

    protected void end() {
    	Robot.elevator.stop();
    }

    protected void interrupted() {
    	end();
    }
}
