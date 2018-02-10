package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveTo;
import org.usfirst.frc.team1515.robot.commands.auto.AutoStrategy;
import org.usfirst.frc.team1515.robot.positions.StartPositions;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {
	public Auto(AutoStrategy auto, StartPositions start) {
		switch(start){
		case LEFT:
			switch(auto) {
			case CenterSwitch:
				break;
			case CrossBaseline:
				break;
			case SlideSwitch:
				break;
			case SlideScale:
				break;
			default:
				break;
			}
			break;
		case CENTER:
			break;
		case RIGHT:
			break;
		default:
			break;
		}
	}
}
