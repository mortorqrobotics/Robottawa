
package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.subsystems.CakeDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static CakeDrive driveTrain;
	public static Joystick driveStick;
	
	public static SmartDashboard smartDashboard;

	@Override
	public void robotInit() {
		driveTrain = new CakeDrive(RobotMap.LEFT_MOTOR_PORTS, RobotMap.RIGHT_MOTOR_PORTS,
			RobotMap.LEFT_ENCODER_PORTS, RobotMap.RIGHT_ENCODER_PORTS,
			RobotMap.LEFT_SOLENOID_PORTS, RobotMap.RIGHT_SOLENOID_PORTS
		);
		driveStick = new Joystick(Controls.DRIVE_STICK);

		// OI needs to be initialized last or else commands will not work!
		oi = new OI();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		smartDashboard.putNumber("encoder", driveTrain.getLeftEncoder());
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
