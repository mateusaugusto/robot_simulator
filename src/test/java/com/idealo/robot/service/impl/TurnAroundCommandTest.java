package com.idealo.robot.service.impl;

import com.idealo.robot.domain.ControlCommands;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.service.impl.RobotControlServiceImpl;
import com.idealo.robot.service.impl.TurnAroundCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TurnAroundCommandTest {

    @InjectMocks
    private TurnAroundCommand service;

    @Test
    public void should_turn_around_north_to_south() throws Exception {
        String[] comand = {"NORTH"};
        Robot robot = new Robot();
        robot.setDirection(Direction.NORTH);
        service.applyCommand(comand, robot);
        assertThat(robot.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void should_turn_around_west_to_east() throws Exception {
        String[] comand = {"WEST"};
        Robot robot = new Robot();
        robot.setDirection(Direction.WEST);
        service.applyCommand(comand, robot);
        assertThat(robot.getDirection()).isEqualTo(Direction.EAST);
    }

}