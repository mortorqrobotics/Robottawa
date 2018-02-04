package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;

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
<<<<<<< HEAD
		Robot.driveTrain.setSpeed(speed);
=======
		Robot.driveTrain.setSpeed(speed):
>>>>>>> 68131a2e5a39c53638176a60ab8e36b891598f78
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
<<<<<<< HEAD
        return ticks == Math.abs((Robot.driveTrain.getLeftEncoder() + Robot.driveTrain.getRightEncoder()) / 2);
=======
        return ticks == Math.abs((Robot.driveTrain.getRightEncoders + Robot.driveTrain.getRightEncoders()) / 2);
>>>>>>> 68131a2e5a39c53638176a60ab8e36b891598f78
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
