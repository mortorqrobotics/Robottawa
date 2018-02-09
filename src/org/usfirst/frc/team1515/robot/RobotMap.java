package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.util.Pair;

public class RobotMap {
	
	public static final int[] LEFT_MOTOR_PORTS = {32};
	public static final int[] RIGHT_MOTOR_PORTS = {31};
	
	public static final Pair<Integer> LEFT_ENCODER_PORTS = new Pair<Integer>(0, 1);
	public static final Pair<Integer> RIGHT_ENCODER_PORTS = new Pair<Integer>(2, 3);

	public static final Pair<Integer> SOLENOID_CHANNELS = new Pair<Integer>(0, 1);
	
	public static final int PDP = 11;
	public static final int PCM = 10;
	
	public static final int TICKS_PER_REV = 2880;
	public static final double WHEEL_CIRCUMFERENCE = Math.PI * 6; //inches

}
