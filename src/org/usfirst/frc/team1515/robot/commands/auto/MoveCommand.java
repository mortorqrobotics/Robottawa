package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;
import org.usfirst.frc.team1515.robot.util.coordsystem.Point;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCommand extends CommandGroup {

	final double SPEED = 0.5;
	final Point DEST;
	
	int toRotate;
	int moveDist;
	
	public MoveCommand(Point destination) { 
		this.DEST = destination;
		
		toRotate = (int) Math.round(PlaneUtil.getAngle(DEST));
		moveDist = (int) Math.round(PlaneUtil.getDistance(DEST));	
		
		if (toRotate > 0) {
			this.addSequential(new TurnAnglePID(toRotate, SPEED));
		}

		this.addSequential(new DriveForward(moveDist, SPEED));
	}

	public MoveCommand(Point destination, boolean endFacingForward) {
		this(destination);

		if (endFacingForward) {
			this.addSequential(new TurnAnglePID(-toRotate, SPEED));
		}

	}

	@Override
	protected void end() {
		PlaneUtil.setCurrentLoc(DEST);
	}
}
