package com.example.craback.controllers;


import com.example.craback.Repository.ProjectRepository;
import com.example.craback.models.Project;
import com.example.craback.service.ProjectService;
import com.example.craback.service.UserService;
import com.example.craback.service.impl.ProjectServiceImpl;
import com.example.craback.utils.Listids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN)')")
    public List<Project> getAllProjects(@RequestParam(required = false) String name){

        return this.projectService.findAllProjects();

    }

    @GetMapping("/projects/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN)')")
    public Project getProjectById(@PathVariable("id") Long id) {

        return this.projectService.findProjectById(id);

    }

    @PostMapping("/projects")
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN)')")
    public Project createProject(@Valid @RequestBody Project project) {

        return this.projectService.createProject(project);
    }

    @PostMapping("/projects/{id}/users")
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN)')")
    Project addUsersToProject(@PathVariable("id") Long id, @RequestBody Listids uIds) {

        Project project = this.projectService.findProjectById(id);
        userService.addUsersToProject(uIds, project);
        return this.projectService.findProjectById(id);
    }

    @PutMapping("/projects/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN)')")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        Optional<Project> projectData = projectRepository.findById(id);
        if (projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setName(project.getName());
            _project.setDescription(project.getDescription());
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/projects/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN)')")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") Long id) {
        try {
            projectRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
