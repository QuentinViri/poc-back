package com.example.craback.service.impl;


import com.example.craback.Repository.ProjectRepository;
import com.example.craback.models.Project;
import com.example.craback.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProjects(){

        return this.projectRepository.findAll();
    }

    @Override
    public Project findProject(Long id) {

        return this.projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project createProject(Project project) {

        project.setDate(LocalDate.now());

        return this.projectRepository.save(project);
    }




}
