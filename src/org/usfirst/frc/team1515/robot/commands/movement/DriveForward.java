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

    protected void initialize() {
		Robot.driveTrain.resetEncoders();
    }

    protected void execute() {
		Robot.driveTrain.setSpeed(speed);
    }

    protected boolean isFinished() {
        return ticks == Math.abs((Robot.driveTrain.getLeftEncoderTicks() + Robot.driveTrain.getRightEncoderTicks()) / 2);
    }

    protected void end() {
		Robot.driveTrain.stop();
    }

    protected void interrupted() {
		end();
    }
}
