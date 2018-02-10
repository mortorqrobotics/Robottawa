package org.usfirst.frc.team1515.robot.positions;

/**
 * @author Elias Schablowski
 *
 */
public enum StartPositions {
	LEFT(0, 16.5, 90),
	CENTER(32, 16.5, 90),
	RIGHT(64, 16.5, 90);
	private double x, y, angle;
	private StartPositions(double x, double y, double angle) {
		this.x=x;
		this.y=y;
		this.angle=angle;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getAngle() {
		return angle;
	}
}
