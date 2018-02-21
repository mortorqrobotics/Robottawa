package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseElevator extends Command {
	
	private double speed;
	private static final double INITIAL = .3, INCREMENT = 1.1, MAX = .7;
	
    public RaiseElevator() {
    	requires(Robot.elevator);
    }
    
    public RaiseElevator(double timeout) {
    	requires(Robot.driveTrain);
    	setTimeout(timeout);
    }

    public void initialize() {
    	speed = INITIAL;
    	Robot.elevator.setSpeed(speed);
    }

    protected void execute() {
    	Robot.elevator.raise();
    	Robot.elevator.setSpeed(speed);
    	speed = Math.min(speed * INCREMENT, MAX);
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
