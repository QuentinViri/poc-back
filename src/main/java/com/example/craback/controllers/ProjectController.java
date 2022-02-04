package com.example.craback.controllers;


import com.example.craback.Repository.ProjectRepository;
import com.example.craback.models.Project;
import com.example.craback.service.ProjectService;
import com.example.craback.service.UserService;
import com.example.craback.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @GetMapping("/projects")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN)')")
    public List<Project> getAllProjects(@RequestParam(required = false) String name){

        return this.projectService.findAllProjects();

    }

    @GetMapping("/projects/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN)')")
    public Project getProjectById(@PathVariable("id") long id) {

        return this.projectService.findProjectById(id);

    }

    @PostMapping("/projects")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN)')")
    public Project createProject(@Valid @RequestBody Project project) {

        return this.projectService.createProject(project);
    }

    @PatchMapping("/projects/{id}/users")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN)')")
    Project addUsersToProject(@PathVariable("id") Long id, @RequestBody List<Long> uIds) {

        Project project = this.projectService.findProjectById(id);
        userService.addUsersToProject(uIds, project);
        return this.projectService.findProjectById(id);
    }


}
