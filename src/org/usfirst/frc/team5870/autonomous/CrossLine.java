package org.usfirst.frc.team5870.autonomous;

import org.usfirst.frc.team5870.robot.commands.AutoTurnLeft;
import org.usfirst.frc.team5870.robot.commands.AutoTurnRight;
import org.usfirst.frc.team5870.robot.commands.DriveForward;
import org.usfirst.frc.team5870.robot.commands.Intake;
import org.usfirst.frc.team5870.robot.commands.StopIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossLine extends CommandGroup{
	
	public static int position = 0;
	
	public CrossLine(int position) {
		this.position = position;
		
		autonomousDoSomething();
	}
	
	public void autonomousDoSomething() {
		switch (position){
		case 0://Drive forward
			addSequential(new DriveForward(-0.4));
			break;
		case 1://Starting on left side
			addSequential(new DriveForward(-0.4),1.8);
			addSequential(new AutoTurnRight(0.5));
			break;
		case 2: //Starting on right side
			addSequential(new DriveForward(-0.4),1.8);
			addSequential(new AutoTurnLeft(0.5));
			break;
		case 3://Starting in center
			addSequential(new DriveForward(-0.1));
			break;
		
		}
	

	}
}
