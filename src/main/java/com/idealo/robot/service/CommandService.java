package com.idealo.robot.service;

import com.idealo.robot.domain.Robot;
import com.idealo.robot.exception.BusinessException;

public interface CommandService {

    void applyCommand(String[] command, Robot robot);
}
