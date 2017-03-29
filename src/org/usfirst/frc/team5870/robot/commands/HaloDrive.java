package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HaloDrive extends Command {
	
	 public HaloDrive() {
	        // Use requires() here to declare subsystem dependencies
	        requires(Robot.chassis);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	double forwardPower = -Robot.oi.drive.getRawAxis(1);
	    	double turnMod =Robot.oi.drive.getRawAxis(4);
	    	double leftPower = forwardPower;
	    	double rightPower = forwardPower;
	    	double percent = 0.60;
	    	
	    	if (forwardPower > -0.10 && forwardPower < 0.10) { // Added deadzone, if forwardPower is less than 0.5, robot does not move forward
	    		forwardPower = 0;
	    	
	    	}
	    	
	    	if (leftPower > -0.15 && leftPower < 0.15) {
				leftPower = 0;
			}
			
			if (rightPower > -0.15 && rightPower < 0.15) {
				rightPower = 0;
			}
	    	
	    	if (turnMod > -0.15 && turnMod < 0.15) { // Added deadzone, if forwardPower is less than 0.5, robot does not move forward
	    		turnMod = 0;
	    	}
	    	
	    	if (forwardPower < 0) { //switches directions when moving backwards
	    		turnMod *= -1;
	    	}
	    	
	    	
	    	if (turnMod > 0 && turnMod > -0.15 && turnMod < 0.15) {    		//reduce power of opposite side by the turnMod
	    		rightPower *= 1 - Math.abs(turnMod*percent);
	    	}
	    	
	    	if (turnMod < 0 && turnMod > -0.15 && turnMod < 0.15) { 
	    		leftPower *= 1 - Math.abs(turnMod*percent); 
	    	}
	    	
	    	if (forwardPower == 0) {  //if forward = 0, then zero point turn 		 
				leftPower = turnMod;
				rightPower = -turnMod;    		   		
	    	}
	    	//System.out.println(leftPower + "  " + rightPower);
	    	
	    	Robot.chassis.power(leftPower,rightPower);
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    	Robot.chassis.power(0,0); // stop motors when not using joystick
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }

}
