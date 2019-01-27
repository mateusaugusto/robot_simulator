package com.idealo.robot.service;

import com.idealo.robot.domain.ControlCommands;
import com.idealo.robot.domain.Robot;

public interface RobotControlService {
    Robot execute(ControlCommands controlCommands);
}
