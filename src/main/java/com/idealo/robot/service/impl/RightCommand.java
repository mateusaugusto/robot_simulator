package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.service.CommandService;

public class RightCommand implements CommandService {

    private static String RIGHT = "RIGHT";

    @Override
    public void applyCommand(String[] command, Robot robot) {
        Direction direction = Direction.rotateDirection(robot.getDirection(), RIGHT);
        robot.setDirection(direction);
    }
}
