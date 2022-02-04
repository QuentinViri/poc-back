package com.example.craback.controllers;

import com.example.craback.models.Project;
import com.example.craback.models.User;
import com.example.craback.service.ProjectService;
import com.example.craback.service.UserService;
import com.example.craback.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;


    @Autowired
    private WorkTimeService worktimeService;

    @GetMapping("/users")
    List<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    User findUser(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return user;
    }

    @GetMapping("/users/{id}/projects")
    Set<Project> findProjects(@PathVariable Long id) {
        return userService.findUserById(id).getProjects();
    }





}
