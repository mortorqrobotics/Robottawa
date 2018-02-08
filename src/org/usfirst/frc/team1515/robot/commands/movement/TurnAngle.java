package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnAngle extends Command {
	
	static final double SPEED = 0.17;
	static final double THRESHOLD = 1;
	
	double target;
	double startAngle;

    public TurnAngle(double target) {
    	requires(Robot.driveTrain);
    	this.target = target;
    }

    protected void initialize() {
    	startAngle = Robot.gyro.getAngle();
    }

    protected boolean isFinished() {
    	Robot.driveTrain.setSpeeds(SPEED, -SPEED);
    	return (Robot.gyro.getAngle() - startAngle) > (target - THRESHOLD)
    			&& (Robot.gyro.getAngle() - startAngle) < (target + THRESHOLD);
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
