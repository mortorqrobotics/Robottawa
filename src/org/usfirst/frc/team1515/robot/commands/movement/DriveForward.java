package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {

	private static final double THRESHOLD = 1;

	private double dist; // inches
	private double speed;

    public DriveForward(double dist, double speed) {
        requires(Robot.driveTrain);
		this.dist = dist;
		this.speed = speed;
    }

    protected void initialize() {
    	System.out.println("drive forward");
    	System.out.println(dist);
		Robot.driveTrain.resetEncoders();
    }

    protected void execute() {
		Robot.driveTrain.setSpeed(speed);
		SmartDashboard.putNumber("distance", Robot.driveTrain.getDistance());
    }

	protected boolean isFinished() {
		return dist <= Robot.driveTrain.getDistance() + THRESHOLD;
	}

    protected void end() {
		Robot.driveTrain.stop();
    }

    protected void interrupted() {
		end();
    }
}
