package com.idealo.robot.service.impl;

import com.idealo.robot.domain.ControlCommands;
import com.idealo.robot.domain.Grid;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.exception.BusinessException;
import com.idealo.robot.service.impl.RobotControlServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RobotControlServiceTest {


    @InjectMocks
    private RobotControlServiceImpl service;

    @Test
    public void should_not_return_result_grid_x3_y5() throws BusinessException {
        Robot robotResult = new Robot();
        robotResult.setGrid(new Grid(0, 1));
        robotResult.setDirection(Direction.NORTH);

        ControlCommands controlCommands = new ControlCommands();
        List<String> commandList = Arrays.asList("POSITION 1 3 EAST", "FORWARD 3", "RIGHT", "RIGHT", "FORWARD 1", "RIGHT", "FORWARD 2");
        controlCommands.setCommands(commandList);

        Robot robot = service.execute(controlCommands);

        assertThat(robot).isNotEqualTo(robotResult);
    }

    @Test
    public void should_return_result_grid_x3_y5() throws BusinessException {
        Robot robotResult = new Robot();
        robotResult.setGrid(new Grid(3, 5));
        robotResult.setDirection(Direction.NORTH);

        ControlCommands controlCommands = new ControlCommands();
        List<String> commandList = Arrays.asList("POSITION 1 3 EAST", "FORWARD 3", "RIGHT", "RIGHT", "FORWARD 1", "RIGHT", "FORWARD 2");
        controlCommands.setCommands(commandList);

        Robot robot = service.execute(controlCommands);

        assertThat(robot).isEqualTo(robotResult);
    }

}
