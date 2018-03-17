package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.CloseIntake;
import org.usfirst.frc.team1515.robot.commands.Delay;
import org.usfirst.frc.team1515.robot.commands.IntakeCube;
import org.usfirst.frc.team1515.robot.commands.OpenIntake;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.RaiseElevator;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team1515.robot.util.Position;

public class CenterAuto extends CommandGroup {
	
	private static final double ELEVATOR_SWITCH_TIME = 3;

	public CenterAuto() {
		PlaneUtil.setCurrentLoc(FieldMap.START_CENTER);

//		addSequential(new CloseIntake());
//		addSequential(new Delay(1));
//		addSequential(new IntakeCube(1.5));
		addParallel(new RaiseElevator(ELEVATOR_SWITCH_TIME));
		addSequential(new MoveCommand(FieldMap.CENTER_OFFSET));
		
		switch (Robot.switchPosition) {
		case LEFT:
			goToLeftSwitch();
			break;
		case RIGHT:
			goToRightSwitch();
			break;
		}
		addSequential(new PurgeCube());
	}

	private void goToLeftSwitch() {
		addSequential(new MoveCommand(FieldMap.CENTER_LEFT_MIDPOINT));
		addSequential(new MoveCommand(FieldMap.CENTER_LEFT_SWITCH));
	}

	private void goToRightSwitch() {
		addSequential(new MoveCommand(FieldMap.CENTER_RIGHT_MIDPOINT));
		addSequential(new MoveCommand(FieldMap.CENTER_RIGHT_SWITCH));
	}
}
