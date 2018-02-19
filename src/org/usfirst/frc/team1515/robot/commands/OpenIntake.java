package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OpenIntake extends Command {

    public OpenIntake() {
    	requires(Robot.intake);
    }
    
    @Override
    protected void initialize() {
    	Robot.intake.open();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
