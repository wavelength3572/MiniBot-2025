// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
 * Initially from https://github.com/Mechanical-Advantage/RobotCode2022
 */

package frc.robot.operator_interface;

import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * Utility class for selecting the appropriate OI implementations based on the connected joysticks.
 */
public class OISelector {
  private static String[] lastJoystickNames = new String[] {null, null, null, null, null, null};
  private static final Alert noOperatorInterfaceWarning =
      new Alert("No operator controller(s) connected.", AlertType.kWarning);

  private OISelector() {} // Constructor - Empty

  /**
   * Returns whether the connected joysticks have changed since the last time this method was
   * called.
   */
  public static boolean didJoysticksChange() {
    boolean joysticksChanged = false;
    for (int port = 0; port < DriverStation.kJoystickPorts; port++) {
      String name = DriverStation.getJoystickName(port);
      if (!name.equals(lastJoystickNames[port])) {
        lastJoystickNames[port] = name;
        joysticksChanged = true;
      }
    }
    return joysticksChanged;
  }

  /**
   * Instantiates and returns an appropriate OperatorInterface object based on the connected
   * joysticks.
   */
  public static OperatorInterface findOperatorInterface() {
    Integer interlinkDXPort = null;

    for (int port = 0; port < DriverStation.kJoystickPorts; port++) {
      System.out.println("Joystick Name:[" + DriverStation.getJoystickName(port) + "]");
      if (DriverStation.getJoystickName(port).toLowerCase().contains("interlinkdx")
          || DriverStation.getJoystickName(port).toLowerCase().contains("interlink")) {
        if (interlinkDXPort == null) {
          interlinkDXPort = port;
        }
      }
    }

    if (interlinkDXPort != null) {
      noOperatorInterfaceWarning.set(false);
      return new InterLinkDXOI(interlinkDXPort);
    } else {
      noOperatorInterfaceWarning.set(true);
      return new OperatorInterface() {}; // Return empty interface
    }
  }
}
