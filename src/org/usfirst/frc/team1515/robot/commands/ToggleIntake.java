package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleIntake extends Command {

    public ToggleIntake() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.toggle();
    }

    protected boolean isFinished() {
        return true;
    }

}
