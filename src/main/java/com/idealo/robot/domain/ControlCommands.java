package com.idealo.robot.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ControlCommands {
    private List<String> commands = new ArrayList<>();
}
