
package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.subsystems.CakeDrive;
import org.usfirst.frc.team1515.robot.util.RobotInfo;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static CakeDrive driveTrain;
	public static Joystick driveStick;
	public static PowerDistributionPanel pdp;
	
	public static DriverStation driverStation;
	public static SmartDashboard smartDashboard;
	public static RobotInfo info;

	@Override
	public void robotInit() {
		driveTrain = new CakeDrive(RobotMap.LEFT_MOTOR_PORTS, RobotMap.RIGHT_MOTOR_PORTS,
			RobotMap.LEFT_ENCODER_PORTS, RobotMap.RIGHT_ENCODER_PORTS,
			RobotMap.SOLENOID_CHANNELS
		);
		driveStick = new Joystick(Controls.DRIVE_STICK);
		pdp = new PowerDistributionPanel(RobotMap.PDP);
		this.info=new RobotInfo(RobotMap.startX, RobotMap.starty, RobotMap.startAngle);
		// OI needs to be initialized last or else commands will not work!
		oi = new OI();
		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
		UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture();
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
//		smartDashboard.putNumber("encoder", driveTrain.getLeftEncoder());
//		smartDashboard.putNumber("current", pdp.getCurrent(0));
//		System.out.println(pdp.getCurrent(0));
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
