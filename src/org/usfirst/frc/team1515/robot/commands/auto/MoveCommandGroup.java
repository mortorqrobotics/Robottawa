package org.usfirst.frc.team1515.robot.commands.auto;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAnglePID;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;
import org.usfirst.frc.team1515.robot.util.coordsystem.Point;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCommandGroup extends CommandGroup {
	final double SPEED = 4.0;
	final Point DEST;
	
    public MoveCommandGroup(Point destination) {
    	this.DEST = destination;
    	
    	int toRotate = (int) Math.round(PlaneUtil.getAngle(DEST));
    	int moveDist = (int) Math.round(PlaneUtil.getAngle(DEST));
    	
    	this.addSequential(new TurnAnglePID(toRotate, SPEED));
    	this.addSequential(new DriveForward(moveDist, SPEED));
    	this.addSequential(new TurnAnglePID(-1 * toRotate, SPEED));
    }
    
    @Override
    protected void end() {
    	PlaneUtil.setCurrentLoc(DEST);
    }
}
