
package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.auto.CenterSwitchAuto;
import org.usfirst.frc.team1515.robot.commands.auto.CrossBaselineAuto;
import org.usfirst.frc.team1515.robot.commands.auto.SideSwitchAuto;
import org.usfirst.frc.team1515.robot.subsystems.CakeDrive;
import org.usfirst.frc.team1515.robot.subsystems.Elevator;
import org.usfirst.frc.team1515.robot.subsystems.Intake;
import org.usfirst.frc.team1515.robot.util.Position;
import org.usfirst.frc.team1515.robot.util.coordsystem.Point;
import org.usfirst.frc.team1515.robot.util.coordsystem.PlaneUtil;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static CakeDrive driveTrain;
	public static Joystick driveStick;
	public static Joystick manipStick;
	public static PowerDistributionPanel pdp;
	public static Gyro gyro;
	public static Elevator elevator;
	public static Intake intake;
	
	public static DriverStation driverStation;
	public static SmartDashboard smartDashboard;

	@Override
	public void robotInit() {
		driveTrain = new CakeDrive(RobotMap.LEFT_MOTOR_PORTS, RobotMap.RIGHT_MOTOR_PORTS,
			RobotMap.LEFT_ENCODER_PORTS, RobotMap.RIGHT_ENCODER_PORTS,
			RobotMap.DRIVE_SOLENOID_CHANNELS
		);
		driveStick = new Joystick(Controls.DRIVE_STICK);
		pdp = new PowerDistributionPanel(RobotMap.PDP);
		gyro = new ADXRS450_Gyro();
		elevator = new Elevator(RobotMap.ELEVATOR_MOTOR_PORTS);
		intake = new Intake(RobotMap.INTAKE_MOTOR_PORTS, RobotMap.INTAKE_SOLENOID_CHANNELS, RobotMap.LIMIT_SWITCH_PORT);
		
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
		String startPositionString = smartDashboard.getString("start position", "L");
		Position startPosition = Position.LEFT;
		Point fieldStartPosition = FieldMap.START_LEFT;

		switch (startPositionString) {
		case "L":
			startPosition = Position.LEFT;
			fieldStartPosition = FieldMap.START_LEFT;
			break;
		case "C":
			startPosition = Position.CENTER;
			fieldStartPosition = FieldMap.START_CENTER;
			break;
		case "R":
			startPosition = Position.RIGHT;
			fieldStartPosition = FieldMap.START_RIGHT;
			break;
		}
		PlaneUtil.setCurrentLoc(fieldStartPosition);

		String data = driverStation.getGameSpecificMessage();
		Position allianceSwitchPosition = data.substring(0, 1) == "L" ? Position.LEFT : Position.RIGHT;
		Command autoCommand;

		if (startPosition == allianceSwitchPosition) {
			autoCommand = new SideSwitchAuto(allianceSwitchPosition);
		} else if (startPosition == Position.CENTER) {
			autoCommand = new CenterSwitchAuto(allianceSwitchPosition);
		} else {
			autoCommand = new CrossBaselineAuto(startPosition);
		}
		autoCommand.start();
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
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
