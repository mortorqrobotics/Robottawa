package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.util.StartPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SwitchAuto extends CommandGroup {
	
	public SwitchAuto(StartPosition startPosition) {
		switch(startPosition) {
		case LEFT:
			left();
		case RIGHT:
			right();
		case CENTER:
			center();
		}
    }
	
	private void left() {
		
	}
	
	private void right() {
		
	}
	
	private void center() {
		
	}
}
