package com.idealo.robot.service.impl;

import com.idealo.robot.domain.Robot;
import com.idealo.robot.service.CommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class WaitCommand implements CommandService {

    private static Logger log = LoggerFactory.getLogger(WaitCommand.class);

    @Override
    public void applyCommand(String[] command, Robot robot) {
        log.info("just wating 1 second");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
