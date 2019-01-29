package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Grid;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.service.CommandService;

public class TurnAroundCommand implements CommandService {

    @Override
    public void applyCommand(String[] command, Robot robot) {
        Direction direction = Direction.rotateTurnAround(robot.getDirection());
        robot.setDirection(direction);
    }
}
