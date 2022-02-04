package com.example.craback.controllers;

import com.example.craback.service.ProjectService;
import com.example.craback.service.UserService;
import com.example.craback.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class WorkTimeController {

    @Autowired
    private WorkTimeService workTimeService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;


}
