package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.RobotMap;
import org.usfirst.frc.team1515.robot.util.MotorModule;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	MotorModule motors;
	DigitalInput limitSwitchTop;
	DigitalInput limitSwitchBottom;
	
	private static final double MIN_SPEED = 0.4;
	private static final double MAX_SPEED = 1.0;
	private static final double CLIMB_SPEED = 0.5;
	private static final double MAX_SPEED_DOWN = 0.95;
	private static final double DESIRED_RAMP_TIME = 1;
	private static final double SPEED_INCREMENT = Math.pow((MAX_SPEED / MIN_SPEED), (1 / (RobotMap.CODE_CYCLES_PER_SECOND * DESIRED_RAMP_TIME)));

	private double speed;
	
	public Elevator(int[] talonPorts, int limitSwitchPortTop, int limitSwitchPortBottom) {
		motors = new MotorModule(talonPorts);
		limitSwitchTop = new DigitalInput(limitSwitchPortTop);
		limitSwitchBottom = new DigitalInput(limitSwitchPortBottom);
		
		setMinSpeed();
	}
	MotorModule test_motor = new MotorModule(RobotMap.TEST_MOTORS[0]);
	public void test() {
		test_motor.setSpeed(speed);
	}

	public void raise() {
		motors.setSpeed(speed);
	}
	
	public void lower() {
		motors.setSpeed(-speed);
	}
	
	public void stop() {
		motors.stop();
	}
	
	public boolean isLimitSwitchTopPressed() {
		return !limitSwitchTop.get();
	}
	
	public boolean isLimitSwitchBottomPressed() {
		return !limitSwitchBottom.get();
	}
	
	public void incrementSpeed() {
		if (speed < MAX_SPEED) {
			speed *= SPEED_INCREMENT;
			System.out.println(speed);
		}
	}
	
	public void setMinSpeed() {
		speed = MIN_SPEED;
	}
	
	public void setMaxSpeed() {
		speed = MAX_SPEED;
	}
	
	public void setMaxSpeedDown() {
		speed = MAX_SPEED_DOWN;
	}
	
	public void setClimbSpeed() {
		speed = CLIMB_SPEED;
	}

    public void initDefaultCommand() {
    }
}

