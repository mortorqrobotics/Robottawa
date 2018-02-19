package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LockIntake extends Command {

    public LockIntake() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.lock();
    }

    protected boolean isFinished() {
        return true;
    }
}