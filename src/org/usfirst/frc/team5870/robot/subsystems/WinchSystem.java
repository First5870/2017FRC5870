package org.usfirst.frc.team5870.robot.subsystems;

import org.usfirst.frc.team5870.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchSystem extends Subsystem {
	private Victor winchMotor1 = new Victor(RobotMap.winchMotor1);
	private Victor winchMotor2 = new Victor(RobotMap.winchMotor2);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void power(double power) {
		winchMotor1.set(power);
		winchMotor2.set(power);
	}
	

}
