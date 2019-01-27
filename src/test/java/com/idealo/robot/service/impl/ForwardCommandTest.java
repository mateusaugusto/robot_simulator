package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Grid;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ForwardCommandTest {

    @InjectMocks
    private ForwardCommand service;

    @Test
    public void should_move_3_times_grid_till_x4() throws Exception {
        String[] command = new String[]{"FORWARD", "3"};

        Robot robot = new Robot();
        robot.setDirection(Direction.EAST);
        robot.setGrid(new Grid(1,3));
        service.applyCommand(command, robot);
        assertThat(robot.getGrid().getX()).isEqualTo(4);
    }

    @Test
    public void should_move_3_times_grid_till_y2() throws Exception {
        String[] command = new String[]{"FORWARD", "1"};

        Robot robot = new Robot();
        robot.setDirection(Direction.EAST);
        robot.setGrid(new Grid(1,1));
        service.applyCommand(command, robot);
        assertThat(robot.getGrid().getX()).isEqualTo(2);
    }

}