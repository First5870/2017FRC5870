package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.DriveType;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveSelector extends CommandGroup {

	// Selects proper drive controls
    public DriveSelector(DriveType driveType) {
    	switch (driveType) {
		case HALO:
			addSequential(new HaloDrive());
			break;
		case TANK:
			addSequential(new TankDrive());
			break;
		case TRIGGER:
			addSequential(new TriggerDrive());
			break;
		default:
			break;
    		
    	}
    }
}
