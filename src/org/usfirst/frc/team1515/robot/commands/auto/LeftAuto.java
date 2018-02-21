package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.RaiseElevator;
import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1515.robot.util.Position;

public class LeftAuto extends CommandGroup {
	
	private static final double ELEVATOR_SWITCH_TIME = 5;

	public LeftAuto() {
		PlaneUtil.setCurrentLoc(FieldMap.START_LEFT);
		System.out.println("left");

		addSequential(new MoveCommand(FieldMap.LEFT_BASELINE));
		addParallel(new RaiseElevator(ELEVATOR_SWITCH_TIME));
		
		boolean canScoreInSwitch = Robot.switchPosition == Position.LEFT;
		boolean canScoreInScale = Robot.scalePosition == Position.LEFT;

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
