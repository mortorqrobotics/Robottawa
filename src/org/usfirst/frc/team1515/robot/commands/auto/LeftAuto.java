package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.util.Position;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAuto extends CommandGroup {

	public LeftAuto() {
		PlaneUtil.setCurrentLoc(FieldMap.START_LEFT);
		addSequential(new MoveCommand(FieldMap.FIRST_LEFT));

		if (Robot.alliancePlatePosition == Position.LEFT) {
			addSequential(new MoveCommand(FieldMap.SECOND_LEFT, false));
			addSequential(new PurgeCube());
		}
	}
}
