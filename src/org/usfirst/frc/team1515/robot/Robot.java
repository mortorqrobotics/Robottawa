
package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.IntegrationTestRoutine;
import org.usfirst.frc.team1515.robot.commands.PurgeCube;
import org.usfirst.frc.team1515.robot.commands.PurgeExchange;
import org.usfirst.frc.team1515.robot.commands.auto.CenterAuto;
import org.usfirst.frc.team1515.robot.commands.auto.LeftAuto;
import org.usfirst.frc.team1515.robot.commands.auto.RightAuto;
import org.usfirst.frc.team1515.robot.subsystems.CakeDrive;
import org.usfirst.frc.team1515.robot.subsystems.Elevator;
import org.usfirst.frc.team1515.robot.subsystems.Intake;

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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1515.robot.util.Position;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static CakeDrive driveTrain;
	public static Joystick driveStick;
	public static Joystick manipStick;
	public static PowerDistributionPanel pdp;
	public static Gyro gyro;
	public static Elevator elevator;
	public static Intake intake;

	public static Command autonomousCommand;
	public static Command testCommand;
	public static Position startPosition;
	public static Position switchPosition;
	public static Position scalePosition;
	public static boolean scaleHasPriority;
	public static int blah = 0; // ignore

	public static SendableChooser<Position> startPositionChooser;
	public static SendableChooser<Boolean> priorityChooser;
	
	@Override
	public void robotInit() {		
		driveTrain = new CakeDrive(RobotMap.LEFT_MOTOR_PORTS, RobotMap.RIGHT_MOTOR_PORTS,
			RobotMap.LEFT_ENCODER_PORTS, RobotMap.RIGHT_ENCODER_PORTS,
			RobotMap.DRIVE_SOLENOID_CHANNELS
		);
		driveStick = new Joystick(Controls.DRIVE_STICK);
		manipStick = new Joystick(Controls.MANIPULATOR_STICK);
		gyro = new ADXRS450_Gyro();
		elevator = new Elevator(RobotMap.ELEVATOR_MOTOR_PORTS, 
				RobotMap.LIMIT_SWITCH_PORT_ELEVATOR_TOP, 
				RobotMap.LIMIT_SWITCH_PORT_ELEVATOR_BOTTOM
		);
		intake = new Intake(RobotMap.INTAKE_MOTOR_PORTS, RobotMap.INTAKE_SOLENOID_CHANNELS);

		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();

		startPositionChooser = new SendableChooser<Position>();
		startPositionChooser.addObject("Left", Position.LEFT);
		startPositionChooser.addObject("Center", Position.CENTER);
		startPositionChooser.addDefault("Right", Position.RIGHT);
		
		SmartDashboard.putData("Start position", startPositionChooser);

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
		String data = DriverStation.getInstance().getGameSpecificMessage();
		switchPosition = data.substring(0, 1).equals("L") ? Position.LEFT : Position.RIGHT;
		scalePosition = data.substring(1, 2).equals("L") ? Position.LEFT : Position.RIGHT;

		startPosition = (Position) startPositionChooser.getSelected();
		scaleHasPriority = false;
//		startPosition = Position.RIGHT;
		
		switch (startPosition) {
		case LEFT:
			autonomousCommand = new LeftAuto();
			break;
		case CENTER:
			autonomousCommand = new CenterAuto();
			break;
		case RIGHT:
			autonomousCommand = new RightAuto();
			break;
		}

		autonomousCommand.start();
	}


	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("right encoder", driveTrain.rightGearbox.getDistance());
		SmartDashboard.putNumber("left encoder", driveTrain.leftGearbox.getDistance());

	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("right encoder", driveTrain.rightGearbox.getDistance());
		SmartDashboard.putNumber("left encoder", driveTrain.leftGearbox.getDistance());
		SmartDashboard.putNumber("gyro", gyro.getAngle());
	}


	@Override
	public void testInit() {
		testCommand = new IntegrationTestRoutine();
		testCommand.start();		
	}
	
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}
