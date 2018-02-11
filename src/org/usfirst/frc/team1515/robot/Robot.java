
package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.auto.CenterAuto;
import org.usfirst.frc.team1515.robot.commands.auto.LeftAuto;
import org.usfirst.frc.team1515.robot.commands.auto.RightAuto;
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
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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

	public static Command autonomousCommand;
	public static Position alliancePlatePosition;
	public static SendableChooser<Command> autoChooser;

	@Override
	public void robotInit() {

		driveTrain = new CakeDrive(RobotMap.LEFT_MOTOR_PORTS, RobotMap.RIGHT_MOTOR_PORTS,
			RobotMap.LEFT_ENCODER_PORTS, RobotMap.RIGHT_ENCODER_PORTS,
			RobotMap.DRIVE_SOLENOID_CHANNELS
		);
		driveStick = new Joystick(Controls.DRIVE_STICK);
		manipStick = new Joystick(Controls.MANIPULATOR_STICK);
//		pdp = new PowerDistributionPanel(RobotMap.PDP);
		gyro = new ADXRS450_Gyro();
		elevator = new Elevator(RobotMap.ELEVATOR_MOTOR_PORTS);
		intake = new Intake(RobotMap.INTAKE_MOTOR_PORTS, RobotMap.INTAKE_SOLENOID_CHANNELS, RobotMap.LIMIT_SWITCH_PORT);

		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
		UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture();

		autoChooser = new SendableChooser<Command>();
		autoChooser.addObject("Left", new LeftAuto());
		autoChooser.addObject("Center", new CenterAuto());
		autoChooser.addObject("Right", new RightAuto());
		SmartDashboard.putData("Start position", autoChooser);

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
		autonomousCommand = (Command) autoChooser.getSelected();
		String data = DriverStation.getInstance().getGameSpecificMessage();
		alliancePlatePosition = data.substring(0, 1) == "L" ? Position.LEFT : Position.RIGHT;
		autonomousCommand.start();
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
