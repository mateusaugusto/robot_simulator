package com.idealo.robot.controller;

import com.idealo.robot.domain.ControlCommands;
import com.idealo.robot.domain.Robot;
import com.idealo.robot.service.RobotControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/robot")
public class RobotControlController {

    private RobotControlService service;

    @Autowired
    public RobotControlController(RobotControlService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Robot> robotSimulator(@RequestBody ControlCommands controlCommands) {
        return ResponseEntity.ok(service.execute(controlCommands));
    }

}
