package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommandGroup;
import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.util.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideSwitchAuto extends CommandGroup {

	public SideSwitchAuto(Position platePosition) {
		switch (platePosition) {
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
		addSequential(new MoveCommandGroup(FieldMap.FIRST_LEFT_SWITCH, false));
		addSequential(new MoveCommandGroup(FieldMap.SECOND_LEFT_SWITCH, false));
	}

	private void goToRightSwitch() {
		addSequential(new MoveCommandGroup(FieldMap.FIRST_RIGHT_SWITCH, false));
		addSequential(new MoveCommandGroup(FieldMap.SECOND_RIGHT_SWITCH, false));
	}
}
