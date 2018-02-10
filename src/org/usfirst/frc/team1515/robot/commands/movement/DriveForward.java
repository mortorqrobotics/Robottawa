package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {

	private static final double THRESHOLD = 2;

	private double dist; // inches
	private double speed;

    public DriveForward(double dist, double speed) {
        requires(Robot.driveTrain);
		this.dist = dist;
		this.speed = speed;
    }

    protected void initialize() {
		Robot.driveTrain.resetEncoders();
    }

    protected void execute() {
		Robot.driveTrain.setSpeed(speed);
    }

	protected boolean isFinished() {
		return dist >= Robot.driveTrain.getDistance() - THRESHOLD
			&& dist <= Robot.driveTrain.getDistance()  + THRESHOLD;
	}

    protected void end() {
		Robot.driveTrain.stop();
    }

    protected void interrupted() {
		end();
    }
}
