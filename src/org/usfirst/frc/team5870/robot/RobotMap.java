package org.usfirst.frc.team5870.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int intakeMotor = 9;
	public static final int winchMotor1 = 6;//There are two winch motors
	public static final int winchMotor2 = 7;
	public static final int gearMotor = 8;
	
	public static final int[] leftMotors = {3, 4, 5};
	public static final int[] rightMotors = {0, 1, 2};
	
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// Not using this >>
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
