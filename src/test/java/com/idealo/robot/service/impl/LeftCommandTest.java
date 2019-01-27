package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.service.impl.LeftCommand;
import com.idealo.robot.service.impl.RightCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LeftCommandTest {

    @InjectMocks
    private LeftCommand service;

    @Test
    public void should_left_north_to_wesr() throws Exception {
        String[] command = {"NORTH"};
        Robot robot = new Robot();
        robot.setDirection(Direction.NORTH);
        service.applyCommand(command, robot);
        assertThat(robot.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void should_left_3_north_till_east() throws Exception {
        String[] command = {"NORTH"};
        Robot robot = new Robot();
        robot.setDirection(Direction.NORTH);
        //West
        service.applyCommand(command, robot);
        //South
        service.applyCommand(command, robot);
        //East
        service.applyCommand(command, robot);
        assertThat(robot.getDirection()).isEqualTo(Direction.EAST);
    }

}