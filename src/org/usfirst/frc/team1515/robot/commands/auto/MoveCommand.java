package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.Delay;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;
import org.usfirst.frc.team1515.robot.util.coordsystem.Point;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCommand extends CommandGroup {

	final double SPEED = 0.5;
	final double DELAY = 0.5;
	final double TURN_TIMEOUT = 1;
	final Point DEST;
	
	int toRotate;
	int moveDist;
	
	public MoveCommand(Point destination) { 
		this.DEST = destination;
		
		toRotate = PlaneUtil.getLeastAngle((int) Math.round(PlaneUtil.getAngle(DEST))/* - PlaneUtil.getCurrentRotate()*/);
		moveDist = (int) Math.round(PlaneUtil.getDistance(DEST));
		
		if (Math.abs(toRotate) > 0) {
			this.addSequential(new TurnAnglePID(toRotate, TURN_TIMEOUT));
			this.addSequential(new Delay(DELAY));
		}

		this.addSequential(new DriveForward(moveDist, SPEED));
		this.addSequential(new Delay(DELAY));
		
//		PlaneUtil.changeRotate(toRotate);
		PlaneUtil.setCurrentLoc(destination);
		System.out.println("dest" + destination);
	}

	public MoveCommand(Point destination, boolean endFacingForward) {
		this(destination);
		if (endFacingForward) {
			this.addSequential(new TurnAnglePID(-PlaneUtil.getCurrentRotate(), TURN_TIMEOUT));
			this.addSequential(new Delay(DELAY));
//			PlaneUtil.changeRotate(-PlaneUtil.getCurrentRotate());
		}

	}

	@Override
	protected void end() {
		PlaneUtil.setCurrentLoc(DEST);
	}
}
