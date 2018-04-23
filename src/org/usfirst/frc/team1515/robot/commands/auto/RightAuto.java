package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.auto.MoveCommand;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.FieldMap;
import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.CloseIntake;
import org.usfirst.frc.team1515.robot.commands.Delay;
import org.usfirst.frc.team1515.robot.commands.IntakeCube;
import org.usfirst.frc.team1515.robot.commands.OpenIntake;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.PurgeExchange;
import org.usfirst.frc.team1515.robot.commands.RaiseElevator;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1515.robot.util.Position;

public class RightAuto extends CommandGroup {
	
	private static final double ELEVATOR_SWITCH_TIME = 3;

	public RightAuto() {
		SmartDashboard.putString("auto", "right");
		PlaneUtil.setCurrentLoc(FieldMap.START_RIGHT);

//		addSequential(new CloseIntake());
//		addSequential(new Delay(1));
//		addSequential(new IntakeCube(1.5));
//		addParallel(new RaiseElevator(ELEVATOR_SWITCH_TIME));
//		addSequential(new MoveCommand(FieldMap.RIGHT_BASELINE));
		addSequential(new DriveForward(95, 0.5));

		boolean canScoreInSwitch = Robot.switchPosition == Position.RIGHT;
		boolean canScoreInScale = false;
		canScoreInSwitch = false;
		
		if (canScoreInSwitch) {
			addSequential(new RaiseElevator(2));
			addSequential(new TurnAnglePID(-90, 1.5));
//			addSequential(new MoveCommand(FieldMap.RIGHT_SWITCH));
			addSequential(new DriveForward(3, 0.25));
			addSequential(new PurgeExchange());
		}

//
//		if (canScoreInScale && (Robot.scaleHasPriority || !canScoreInSwitch)) {
//			addSequential(new MoveCommand(FieldMap.RIGHT_SCALE));
//			addSequential(new TurnAnglePID(-90, 2));
//			addSequential(new RaiseElevator(ELEVATOR_SWITCH_TIME));
//			addSequential(new PurgeCube());
//		} else if (canScoreInSwitch && (!Robot.scaleHasPriority || !canScoreInScale)) {
//			addSequential(new RaiseElevator(ELEVATOR_SWITCH_TIME));
//			addSequential(new MoveCommand(FieldMap.RIGHT_SWITCH));
//			addSequential(new PurgeExchange(0.5));
//			addSequential(new OpenIntake());
//		}
    }
}
