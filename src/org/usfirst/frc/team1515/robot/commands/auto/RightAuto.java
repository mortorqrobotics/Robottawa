package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.util.Position;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAuto extends CommandGroup {

	public RightAuto() {
		PlaneUtil.setCurrentLoc(FieldMap.START_RIGHT);
		addSequential(new MoveCommand(FieldMap.FIRST_RIGHT));
		
		if (Robot.alliancePlatePosition == Position.RIGHT) {
			addSequential(new MoveCommand(FieldMap.SECOND_RIGHT, false));
			addSequential(new PurgeCube());
		}
    }
}
