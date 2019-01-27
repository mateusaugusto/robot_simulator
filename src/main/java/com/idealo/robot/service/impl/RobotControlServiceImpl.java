package com.idealo.robot.service.impl;

import com.idealo.robot.domain.ControlCommands;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Command;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.exception.BusinessException;
import com.idealo.robot.service.RobotControlService;
import org.springframework.stereotype.Service;

@Service
public class RobotControlServiceImpl implements RobotControlService {

    @Override
    public Robot execute(ControlCommands controlCommands) {
        Robot robot = new Robot();

        controlCommands.getCommands().forEach(c -> {
            String[] command = this.getCommandInStringArray(c);
            Command commandEnum = Command.valueOf(command[0]);
            commandEnum.applyCommand(command, robot);
        });

        return robot;
    }

    private String[] getCommandInStringArray(String  command){
        return command.split("\\s+");
    }


}
