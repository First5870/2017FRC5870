package org.usfirst.frc.team5870.robot.subsystems;

import org.usfirst.frc.team5870.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSystem extends Subsystem {
	private Victor gearMotor = new Victor(RobotMap.gearMotor);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void power(double power) {
		gearMotor.set(power);
		//TODO run motor for only 90 degrees.
	}
	
}
