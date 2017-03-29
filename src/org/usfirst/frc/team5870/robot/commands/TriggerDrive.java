package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TriggerDrive extends Command {

    public TriggerDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double forwardPower;
    	
    	if(Robot.oi.drive.getRawAxis(2)>0){
    		forwardPower = -Robot.oi.drive.getRawAxis(2) * 1.5;
    	}
    	else{
    		forwardPower = Robot.oi.drive.getRawAxis(3) * 1.5;
    	}
    	
    	if (forwardPower > 0.6) {//Keeping max power to 60% to preserve battery power
    		forwardPower = 0.6;
    	}
    	
    	if (forwardPower < -0.6) {
    		forwardPower = -0.6;
    	}
    	
    	double turnMod = Robot.oi.drive.getRawAxis(4);
    	double leftPower = forwardPower;
    	double rightPower = forwardPower; 

    	if (leftPower > -0.15 && leftPower < 0.15) {
			leftPower = 0;
		}
		
		if (rightPower > -0.15 && rightPower < 0.15) {
			rightPower = 0;
		}
    	
    	if (forwardPower < 0) { //switches directions when moving backwards
    		turnMod *= -1;
    	}
    	
    	if (turnMod > 0) {    		//reduce power of opposite side by the turnMod
    		rightPower *= 1 - Math.abs(turnMod);
    	}
    	if (turnMod < 0) { 
    		leftPower *= 1 - Math.abs(turnMod); 
    	}
    	if (forwardPower == 0) {  //if forward = 0, then zero point turn 		 
			leftPower = turnMod;
			rightPower = -turnMod;    		   		
    	}
    	
    	Robot.chassis.power(leftPower,rightPower);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

