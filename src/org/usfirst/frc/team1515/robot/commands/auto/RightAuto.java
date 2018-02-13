package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.util.Position;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAuto extends CommandGroup {

	public RightAuto() {
		PlaneUtil.setCurrentLoc(FieldMap.START_RIGHT);

		addSequential(new MoveCommand(FieldMap.RIGHT_BASELINE));

		boolean canScoreInSwitch = Robot.switchPosition == Position.RIGHT;
		boolean canScoreInScale = Robot.scalePosition == Position.RIGHT;

		if (canScoreInScale && (Robot.scaleHasPriority || !canScoreInSwitch)) {
			addSequential(new MoveCommand(FieldMap.RIGHT_SCALE, true));
			addSequential(new TurnAnglePID(-90, 2));
			addSequential(new PurgeCube());
		} else if (canScoreInSwitch && (!Robot.scaleHasPriority || !canScoreInScale)) {
			addSequential(new MoveCommand(FieldMap.RIGHT_SWITCH, false));
			addSequential(new PurgeCube());
		}
    }
}
