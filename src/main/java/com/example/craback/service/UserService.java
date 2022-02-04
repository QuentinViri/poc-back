package com.example.craback.service;

import com.example.craback.models.Project;
import com.example.craback.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAllUsers();
    public Project addUsersToProject(List<Long> ids, Project project);
    public User findUserById(Long id);

}
