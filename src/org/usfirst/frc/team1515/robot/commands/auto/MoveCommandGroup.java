package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;
import org.usfirst.frc.team1515.robot.util.coordsystem.Point;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCommandGroup extends CommandGroup {

	final double SPEED = 0.5;
	final Point DEST;
	
	public MoveCommandGroup(Point destination) { 
		this.DEST = destination;
		
		int moveDist = (int) Math.round(PlaneUtil.getAngle(DEST));	
		
		this.addSequential(new DriveForward(moveDist, SPEED));
	}

	public MoveCommandGroup(Point destination, boolean endFacingForward) {
		this.DEST = destination;

		int toRotate = (int) Math.round(PlaneUtil.getAngle(DEST));
		int moveDist = (int) Math.round(PlaneUtil.getAngle(DEST));
				
		this.addSequential(new TurnAnglePID(toRotate, SPEED));
		this.addSequential(new DriveForward(moveDist, SPEED));

		if(endFacingForward) {
			this.addSequential(new TurnAnglePID(-toRotate, SPEED));
		}

	}

	@Override
	protected void end() {
		PlaneUtil.setCurrentLoc(DEST);
	}
}
