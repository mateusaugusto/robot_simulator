package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Grid;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.exception.BusinessException;
import com.idealo.robot.service.CommandService;

public class PositionCommand implements CommandService {

    public PositionCommand() {
    }

    @Override
    public void applyCommand(String[] command, Robot robot) {
        robot.setDirection(Direction.valueOf(command[3].trim()));
        Grid grid;
        try {
            grid = new Grid(this.convertStringToInt(command[1]), this.convertStringToInt(command[2]));
            robot.setGrid(grid);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }

    private int convertStringToInt(String string){
        return Integer.valueOf(string);
    }
}
