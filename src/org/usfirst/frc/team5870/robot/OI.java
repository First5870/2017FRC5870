package org.usfirst.frc.team5870.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Operator controls
	public Joystick operate = new Joystick(1);
	public JoystickButton intakeBtn = new JoystickButton(operate, 1);
	public JoystickButton reverseIntakeBtn = new JoystickButton(operate, 2);
	public JoystickButton winch = new JoystickButton(operate, 4);
	public JoystickButton reverseWinch = new JoystickButton(operate, 3);
	public JoystickButton gearTake = new JoystickButton(operate, 5);
	public JoystickButton reverseGearTake = new JoystickButton(operate, 6);
	
	// Driver controls
	public Joystick drive = new Joystick(0);
	public JoystickButton increaseGear = new JoystickButton(drive, 6);
	public JoystickButton decreaseGear = new JoystickButton(drive,5);
}