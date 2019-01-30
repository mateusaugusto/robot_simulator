package com.idealo.robot.domain.enums;

import com.idealo.robot.domain.Robot;
import com.idealo.robot.service.CommandService;
import com.idealo.robot.service.impl.*;

public enum Command implements CommandService {

    FORWARD {
        @Override
        public void applyCommand(String[] command, Robot robot) {
            new ForwardCommand().applyCommand(command, robot);
        }
    },
    LEFT {
        @Override
        public void applyCommand(String[] command, Robot robot) {
            new LeftCommand().applyCommand(command, robot);
        }
    },
    RIGHT {
        @Override
        public void applyCommand(String[] command, Robot robot) {
            new RightCommand().applyCommand(command, robot);
        }
    },
    WAIT {
        @Override
        public void applyCommand(String[] command, Robot robot) {
            new WaitCommand().applyCommand(command, robot);
        }
    },
    TURNAROUND {
        @Override
        public void applyCommand(String[] command, Robot robot) {
            new TurnAroundCommand().applyCommand(command, robot);
        }
    },
    POSITION {
        @Override
        public void applyCommand(String[] command, Robot robot) {
            new PositionCommand().applyCommand(command, robot);
        }
    };

}
