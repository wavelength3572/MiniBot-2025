// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.operator_interface;

import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** Operator interface for Interlink DX controller. */
public class InterLinkDXOI implements OperatorInterface {
  private final CommandGenericHID interLinkJoystick;
  private final Trigger[] interLinkJoystickButtons;

  public InterLinkDXOI(int interlinkPort) {
    interLinkJoystick = new CommandGenericHID(interlinkPort);

    // buttons use 1-based indexing such that the index matches the button number;
    // leave index 0 set to null
    this.interLinkJoystickButtons = new Trigger[28];

    for (int i = 1; i < interLinkJoystickButtons.length; i++) {
      interLinkJoystickButtons[i] = interLinkJoystick.button(i);
    }
  }

  @Override
  public double getTranslateX() {
    return interLinkJoystick.getRawAxis(1);
  }

  @Override
  public double getTranslateY() {
    return -interLinkJoystick.getRawAxis(0);
  }

  @Override
  public double getRotate() {
    return -interLinkJoystick.getRawAxis(3);
  }

  @Override
  public Trigger getResetGyroButton() {
    return interLinkJoystickButtons[14]; // RESET Button on back of controller
  }

  @Override
  public Trigger getCalibrateWheelsButton() {
    return interLinkJoystickButtons[15]; // CANCEL/RESET Button (second reset button)
  }

  @Override
  public Trigger getLockWheelsButton() {
    return interLinkJoystickButtons[12]; // Button H - bottom right of top face
  }

  @Override
  public Trigger getLockToZeroButton() {
    return interLinkJoystickButtons[1]; // Button A/V - near upper left top side
  }
}
