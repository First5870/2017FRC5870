
package org.usfirst.frc.team5870.robot;

import org.usfirst.frc.team5870.autonomous.CrossLine;
import org.usfirst.frc.team5870.robot.commands.DriveForward;
import org.usfirst.frc.team5870.robot.commands.DropWinch;
import org.usfirst.frc.team5870.robot.commands.Intake;
import org.usfirst.frc.team5870.robot.commands.RaiseWinch;
import org.usfirst.frc.team5870.robot.commands.ReverseGear;
import org.usfirst.frc.team5870.robot.commands.ReverseIntake;
import org.usfirst.frc.team5870.robot.commands.RunGear;
import org.usfirst.frc.team5870.robot.commands.StopGear;
import org.usfirst.frc.team5870.robot.commands.StopIntake;
import org.usfirst.frc.team5870.robot.commands.StopWinch;
import org.usfirst.frc.team5870.robot.subsystems.ChassisSystem;
import org.usfirst.frc.team5870.robot.subsystems.GearSystem;
import org.usfirst.frc.team5870.robot.subsystems.IntakeSystem;
import org.usfirst.frc.team5870.robot.subsystems.WinchSystem;


import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// Defining inputs
	public static OI oi;
	
	//Choose driving mode
	private static final DriveType driveType = DriveType.TRIGGER;
	
	// Subsystems
	public static final IntakeSystem intake = new IntakeSystem();
	public static final WinchSystem winch = new WinchSystem();
	public static final GearSystem gearTake = new GearSystem();
	public static final ChassisSystem chassis = new ChassisSystem(driveType);
	
	public static CameraServer webcam;
		
//	public static Ultrasonic ultraTest = new Ultrasonic(1,1); //uses DigitalOutput1 for the echo pulse and DigitalInput 1 for the trigger pulse
	
	// Chooser to pick which autonomous commandgroup to run
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	

	// Initializing default functionality
	@Override
	public void robotInit() {
		
		oi = new OI();	
        
        
//		ultraTest.setAutomaticMode(true);  //turns on automatic mode (idfk what this is atm but wplib.screenstepslive says to do it.
//		double range = ultraTest.getRangeInches(); //Get distance between robot and object
//		
//		SmartDashboard.putNumber("Range",range);//Send number to console
		
		webcam = CameraServer.getInstance();
		webcam.startAutomaticCapture("cam0", 0);
		
		chooser.addDefault("Sides (moves forward)", new CrossLine(0));//Choose you autonomous mode
		chooser.addObject("Left Side", new CrossLine(1));
		chooser.addObject("Right Side", new CrossLine(2));
		chooser.addObject("Center", new CrossLine(3));
		//chooser.addObject("experimental", object);
		SmartDashboard.putData("Auto mode", chooser);
	
		oi.intakeBtn.whenPressed(new Intake());
		oi.intakeBtn.whenReleased(new StopIntake());
		
		//oi.reverseIntakeBtn.whenPressed(new ReverseIntake());
		//oi.reverseIntakeBtn.whenReleased(new StopIntake());
		
		oi.winch.whenPressed(new RaiseWinch());
		oi.winch.whenReleased(new StopWinch());
		
		oi.reverseWinch.whenPressed(new DropWinch());
		oi.reverseWinch.whenReleased(new StopWinch());
		
		//oi.gearTake.whenPressed(new RunGear());
		//oi.gearTake.whenReleased(new StopGear());
		
		//oi.reverseGearTake.whenPressed(new ReverseGear());
		//oi.reverseGearTake.whenReleased(new StopGear());
		
		
	}

	@Override
	public void autonomousInit() {
		
		autonomousCommand = new CrossLine(0); //autonomous is set to sides by default
		
		String autoSelected = SmartDashboard.getString("Auto Mode","Default");//Get selected preference
		switch (autoSelected) {
		
		case "Left Side"://Starting from left side
			autonomousCommand = new CrossLine(1);
			break;
		case "Right Side"://Starting from right side
			autonomousCommand = new CrossLine(2);
		case "Center"://Stating from center
			autonomousCommand = new CrossLine(3);
			break;
		}
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	    }

	// -----------------------------------
	// -- Don't touch beyond this point --
	// -----------------------------------
	
	
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void ultrasonicSample () {
//		SmartDashboard.putNumber("Ultrasonic value", ultraTest.getRangeInches()); //for reading range
	
	}
}
