package org.usfirst.frc.team5870.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * @author Dennis Krasnov
 * RobotDrive implemented for 6 motors
 * Doesn't work for mechanum drive
 */
public class SixRobotDrive extends RobotDrive {
	
	// Not necessary, used for mechanum drive
	protected static final int kMaxNumberOfMotors = 6;
	
	// Default motor output
	public static final double kDefaultMaxOutput = 0.2;
	// Normal motor output
	
	// Adding 5th and 6th drive train motors
	protected SpeedController m_middleLeftMotor;
	protected SpeedController m_middleRightMotor;

	
	// Constructor that allows for 6 motors
	public SixRobotDrive(int flm, int mlm, int rlm, int frm, int mrm, int rrm) {
		super(flm, rlm, frm, rrm);
		m_middleLeftMotor = new Talon(mlm);
		m_middleRightMotor = new Talon(mrm);
	}

	// Limit motor values to the -1.0 to +1.0 range.
	@Override
	public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
		if (m_rearLeftMotor == null || m_rearRightMotor == null) {
	      throw new NullPointerException("Null motor provided");
	    }

	    if (m_frontLeftMotor != null) {
	      m_frontLeftMotor.set(limit(leftOutput) * m_maxOutput);
	    }
	    // Added code
	    if (m_middleLeftMotor != null) {
	    	m_middleLeftMotor.set(limit(leftOutput) * m_maxOutput);
	    }
	    m_rearLeftMotor.set(limit(leftOutput) * m_maxOutput);

	    if (m_frontRightMotor != null) {
	      m_frontRightMotor.set(-limit(rightOutput) * m_maxOutput);
	    }
	    // Added code
	    if (m_middleRightMotor != null) {
	    	m_middleRightMotor.set(-limit(rightOutput) * m_maxOutput);
	    }
	    m_rearRightMotor.set(-limit(rightOutput) * m_maxOutput);

	    if (m_safetyHelper != null) {
	      m_safetyHelper.feed();
	    }
	}
	
	

}
