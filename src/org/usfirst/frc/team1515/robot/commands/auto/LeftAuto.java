package org.usfirst.frc.team1515.robot.commands.auto;

import javax.swing.DebugGraphics;

import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.CloseIntake;
import org.usfirst.frc.team1515.robot.commands.Delay;
import org.usfirst.frc.team1515.robot.commands.IntakeCube;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.RaiseElevator;
import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team1515.robot.util.Position;

public class LeftAuto extends CommandGroup {
	
	private static final double ELEVATOR_SWITCH_TIME = 3;

	public LeftAuto() {
		PlaneUtil.setCurrentLoc(FieldMap.START_LEFT);

//		addSequential(new CloseIntake());
//		addSequential(new Delay(1));
//		addSequential(new IntakeCube(1.5));
		addParallel(new RaiseElevator(ELEVATOR_SWITCH_TIME));
		addSequential(new MoveCommand(FieldMap.LEFT_BASELINE));
		
		boolean canScoreInSwitch = Robot.switchPosition == Position.LEFT;
		boolean canScoreInScale = false;

		if (canScoreInScale && (Robot.scaleHasPriority || !canScoreInSwitch)) {
			addSequential(new MoveCommand(FieldMap.LEFT_SCALE));
			addSequential(new TurnAnglePID(90, 2));
			addSequential(new PurgeCube());
		} else if (canScoreInSwitch && (!Robot.scaleHasPriority || !canScoreInScale)) {
			addSequential(new MoveCommand(FieldMap.LEFT_SWITCH));
			addSequential(new PurgeCube());
		}
	}
}
