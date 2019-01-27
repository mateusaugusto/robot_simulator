package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.service.impl.RightCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RightCommandTest {

    @InjectMocks
    private RightCommand service;

    @Test
    public void should_right_north_to_east() throws Exception {
        String[] comand = {"NORTH"};
        Robot robot = new Robot();
        robot.setDirection(Direction.NORTH);
        service.applyCommand(comand, robot);
        assertThat(robot.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_right_2_north_till_west() throws Exception {
        String[] comand = {"NORTH"};
        Robot robot = new Robot();
        robot.setDirection(Direction.NORTH);
        service.applyCommand(comand, robot);
        service.applyCommand(comand, robot);
        assertThat(robot.getDirection()).isEqualTo(Direction.SOUTH);
    }

}