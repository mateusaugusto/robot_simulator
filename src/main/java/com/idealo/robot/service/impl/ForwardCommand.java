package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Grid;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.exception.BusinessException;
import com.idealo.robot.service.CommandService;

import java.util.stream.IntStream;

public class ForwardCommand implements CommandService {

    @Override
    public void applyCommand(String[] command, Robot robot) {
        int numberOfMovements = Integer.valueOf(command[1].trim());

        IntStream.range(0, numberOfMovements).forEach(movement -> {
            try {
                this.setRobotNewGrid(robot);
            } catch (BusinessException e) {
                throw new BusinessException("Robot missing");
            }
        });
    }

    private void setRobotNewGrid(Robot robot) throws BusinessException {
        int x = robot.getGrid().getX();
        int y = robot.getGrid().getY();

        switch (robot.getDirection()) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }

        robot.setGrid(new Grid(x, y));
    }

}
