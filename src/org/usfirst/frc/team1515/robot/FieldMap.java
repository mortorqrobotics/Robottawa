package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.util.coordsystem.Point;

public class FieldMap {

	// start position
    public static final Point START_CENTER = new Point(182, 41);
    public static final Point START_LEFT = new Point(62, 17);
    public static final Point START_RIGHT = new Point(298, 17);

	// left to switch
    public static final Point FIRST_LEFT_SWITCH = new Point(62, 168);
    public static final Point SECOND_LEFT_SWITCH = new Point(70, 168);

	// left to baseline
	public static final Point FIRST_LEFT_BASELINE = new Point(0, 0);
	public static final Point SECOND_LEFT_BASELINE = new Point(0, 0);

	// right to switch
    public static final Point FIRST_RIGHT_SWITCH = new Point(298, 168);
    public static final Point SECOND_RIGHT_SWITCH = new Point(290, 168);

	// right to baseline
	public static final Point FIRST_RIGHT_BASELINE = new Point(0, 0);
	public static final Point SECOND_RIGHT_BASELINE = new Point(0, 0);

	// center to left switch
    public static final Point FIRST_CENTER_LEFT = new Point(101, 98);
    public static final Point SECOND_CENTER_LEFT = new Point(101, 50);

	// center to right switch
    public static final Point FIRST_CENTER_RIGHT = new Point(0, 0);
    public static final Point SECOND_CENTER_RIGHT = new Point(0, 0);

}
