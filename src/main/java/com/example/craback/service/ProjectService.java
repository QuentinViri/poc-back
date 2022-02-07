package com.example.craback.service;

import com.example.craback.models.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> findAllProjects();
    public Project findProjectById(Long id);
    public Project createProject(Project project);
}