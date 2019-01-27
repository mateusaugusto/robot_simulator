package com.idealo.robot.domain;

import com.idealo.robot.domain.enums.Direction;
import lombok.Data;

@Data
public class Robot {

    private Grid grid;
    private Direction direction;

}
