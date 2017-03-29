package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

    public TankDrive() {
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double left =  Robot.oi.drive.getRawAxis(1); // Left joysticky thing y-axis
    	double right =  Robot.oi.drive.getRawAxis(5); // Right joysticky thing y-axis
    	
    	left = left*-1;//Flipping the controls
    	right = right*-1;
    	
    	System.out.println(left);
    	System.out.println(right);

    	
    	Robot.chassis.power(left, right);
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
