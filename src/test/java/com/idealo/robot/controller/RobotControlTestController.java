package com.idealo.robot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.robot.domain.ControlCommands;
import com.idealo.robot.domain.Grid;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.domain.enums.Direction;
import com.idealo.robot.service.impl.RobotControlServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RobotControlController.class)
public class RobotControlTestController {

    @MockBean
    private RobotControlServiceImpl robotControlService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void should_return_direction_north_and_grid_x3_y5() throws Exception {
        Robot robotResult = new Robot();
        robotResult.setGrid(new Grid(3, 5));
        robotResult.setDirection(Direction.NORTH);

        ControlCommands controlCommands = new ControlCommands();
        List<String> commandList = Arrays.asList("POSITION 1 3 EAST", "FORWARD 3", "RIGHT", "RIGHT", "FORWARD 1", "RIGHT", "FORWARD 2");
        controlCommands.setCommands(commandList);

        given(robotControlService.execute(controlCommands)).willReturn(robotResult);

        mockMvc.perform(post("/robot")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(controlCommands))
                .accept(APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful()).andReturn();

        verify(robotControlService).execute(controlCommands);
    }


    @Test
    public void should_return_direction_north_and_grid_x0_y1() throws Exception {
        Robot robotResult = new Robot();
        robotResult.setGrid(new Grid(0, 1));
        robotResult.setDirection(Direction.NORTH);

        ControlCommands controlCommands = new ControlCommands();
        List<String> commandList = Arrays.asList("POSITION 0 0 NORTH", "FORWARD 1");
        controlCommands.setCommands(commandList);

        given(robotControlService.execute(controlCommands)).willReturn(robotResult);

        mockMvc.perform(post("/robot")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(controlCommands))
                .accept(APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(mapper.writeValueAsString(robotResult)));

        verify(robotControlService, times(1)).execute(controlCommands);
    }

    @Test
    public void should_return_direction_west_and_grid_0_xy0() throws Exception {
        Robot robotResult = new Robot();
        robotResult.setGrid(new Grid(0, 0));
        robotResult.setDirection(Direction.WEST);

        ControlCommands controlCommands = new ControlCommands();
        List<String> commandList = Arrays.asList("POSITION 0 0 NORTH", "LEFT");
        controlCommands.setCommands(commandList);

        given(robotControlService.execute(controlCommands)).willReturn(robotResult);

        mockMvc.perform(post("/robot")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(controlCommands))
                .accept(APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(mapper.writeValueAsString(robotResult)));

        verify(robotControlService, times(1)).execute(controlCommands);

    }

}
