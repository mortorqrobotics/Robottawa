package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.util.Pair;

public class RobotMap {
	
	public static final int[] LEFT_MOTOR_PORTS = {32, 34};
	public static final int[] RIGHT_MOTOR_PORTS = {31, 33};
	
	public static final int[] ELEVATOR_MOTOR_PORTS = {37};
	public static final int[] INTAKE_MOTOR_PORTS = {3, 4};
	
	public static final Pair<Integer> LEFT_ENCODER_PORTS = new Pair<Integer>(0, 1);
	public static final Pair<Integer> RIGHT_ENCODER_PORTS = new Pair<Integer>(2, 3);

	public static final Pair<Integer> INTAKE_SOLENOID_CHANNELS = new Pair<Integer>(0, 1);
	public static final Pair<Integer> DRIVE_SOLENOID_CHANNELS = new Pair<Integer>(4, 5);
	
	public static final int LIMIT_SWITCH_PORT_ELEVATOR_TOP = 4;
	public static final int LIMIT_SWITCH_PORT_ELEVATOR_BOTTOM = 6;
	
	public static final int PDP = 10;
	public static final int PCM = 11;
	
	public static final int TICKS_PER_REV = 2700;
	public static final double WHEEL_CIRCUMFERENCE = Math.PI * 6.25; //inches

}
