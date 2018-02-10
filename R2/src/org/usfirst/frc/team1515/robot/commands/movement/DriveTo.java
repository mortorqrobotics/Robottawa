package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;
import org.usfirst.frc.team1515.robot.commands.movement.TurnAngle;
import org.usfirst.frc.team1515.robot.util.Vector;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveTo extends CommandGroup {

	private static final double ticksPerUnit = 1;
	private double speed, angle, distance;
	private Vector vect;

    public DriveTo(double x, double y) {
    	this.vect = new Vector(Robot.info.x, Robot.info.y, x, y);
    	this.speed = 1;
    	this.init();
    }
    public DriveTo(double x, double y, double speed) {
    	this.vect = new Vector(x, y);
    	this.speed = speed;
    	this.init();
    }
    public void init() {
    	this.angle = this.vect.realAngleBetween(Robot.info.angle);
		this.distance = this.vect.magnitude();
		addSequential(new TurnAnglePID(this.angle));//Just Change when finalized
		addSequential(new DriveForward((int)(ticksPerUnit * this.distance), this.speed));
    }
}
