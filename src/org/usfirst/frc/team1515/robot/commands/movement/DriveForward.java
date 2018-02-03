package org.usfirst.frc.team1515.robot.commands.movement;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {

	private int ticks;
	private double speed;

    public DriveForward(int ticks, double speed) {
        requires(Robot.driveTrain);
		this.ticks = ticks;
		this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.driveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.driveTrain.setSpeed(speed):
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ticks == Math.abs((Robot.driveTrain.getRightEncoders + Robot.driveTrain.getRightEncoders()) / 2);
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		end();
    }
}
