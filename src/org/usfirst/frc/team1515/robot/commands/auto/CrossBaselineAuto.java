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
		addSequential(new MoveCommandGroup(FieldMap.FIRST_LEFT_BASELINE));
		addSequential(new MoveCommandGroup(FieldMap.SECOND_LEFT_BASELINE));
	}

	private	void crossBaselineRight() {
		addSequential(new MoveCommandGroup(FieldMap.FIRST_RIGHT_BASELINE));
		addSequential(new MoveCommandGroup(FieldMap.SECOND_RIGHT_BASELINE));
	}
}
