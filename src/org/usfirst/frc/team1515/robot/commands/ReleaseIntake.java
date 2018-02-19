package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReleaseIntake extends Command {

    public ReleaseIntake() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.release();
    }

    protected boolean isFinished() {
        return true;
    }
}
