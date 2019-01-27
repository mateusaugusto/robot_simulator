package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.service.CommandService;

public class LeftCommand implements CommandService {

    private static String LEFT = "LEFT";

    @Override
    public void applyCommand(String[] command, Robot robot) {
        Direction direction = Direction.rotateDirection(robot.getDirection(), LEFT);
        robot.setDirection(direction);
    }
}
