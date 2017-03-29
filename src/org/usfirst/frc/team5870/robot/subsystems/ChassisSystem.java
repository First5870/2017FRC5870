package org.usfirst.frc.team5870.robot.subsystems;

import org.usfirst.frc.team5870.robot.DriveType;
import org.usfirst.frc.team5870.robot.RobotMap;
import org.usfirst.frc.team5870.robot.SixRobotDrive;
import org.usfirst.frc.team5870.robot.commands.DriveSelector;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChassisSystem extends Subsystem {
	private RobotDrive drive;
	private DriveType driveType;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public ChassisSystem(DriveType driveType) {
		this.driveType = driveType;
		drive = new SixRobotDrive(RobotMap.leftMotors[0], RobotMap.leftMotors[1], RobotMap.leftMotors[2],
				RobotMap.rightMotors[0], RobotMap.rightMotors[1], RobotMap.rightMotors[2]);
	}

	public void initDefaultCommand() {
		// Constantly drives robot
		setDefaultCommand(new DriveSelector(driveType));
	}

	public void power(double powerLeft, double powerRight) {		
		drive.tankDrive(powerLeft, powerRight);
	}

}
