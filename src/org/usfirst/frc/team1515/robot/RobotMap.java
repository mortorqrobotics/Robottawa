package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.positions.StartPositions;
import org.usfirst.frc.team1515.robot.util.Pair;

public class RobotMap {
	
	public static final int[] LEFT_MOTOR_PORTS = {32, 34};
	public static final int[] RIGHT_MOTOR_PORTS = {31, 33};
	
	public static final int[] ELEVATOR_MOTOR_PORTS = {1, 2};
	public static final int[] INTAKE_MOTOR_PORTS = {3, 4};
	
	public static final Pair<Integer> LEFT_ENCODER_PORTS = new Pair<Integer>(0, 1);
	public static final Pair<Integer> RIGHT_ENCODER_PORTS = new Pair<Integer>(2, 3);

	public static final Pair<Integer> DRIVE_SOLENOID_CHANNELS = new Pair<Integer>(0, 1);
	
	public static final Pair<Integer> INTAKE_SOLENOID_CHANNELS = new Pair<Integer>(2, 3);
	
	public static final int LIMIT_SWITCH_PORT = 1;
	
	public static final int PDP = 11;
	public static final int PCM = 10;
	
	public static final StartPositions startPosition = StartPositions.LEFT;
}
