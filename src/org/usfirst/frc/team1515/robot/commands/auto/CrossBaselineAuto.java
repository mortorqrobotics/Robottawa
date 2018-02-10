package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.commands.auto.MoveCommandGroup;
import org.usfirst.frc.team1515.robot.util.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossBaselineAuto extends CommandGroup {

	public CrossBaselineAuto(Position startPosition) {
		switch (startPosition) {
		case LEFT:
			crossBaselineLeft();
			break;
		case RIGHT:
			crossBaselineRight();
			break;
		}
	}

	private void crossBaselineLeft() {
		addSequential(new MoveCommandGroup(FieldMap.FIRST_LEFT_SWITCH));
	}

	private	void crossBaselineRight() {
		addSequential(new MoveCommandGroup(FieldMap.FIRST_RIGHT_SWITCH));
	}
}
