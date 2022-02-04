package com.example.craback.service.impl;

import com.example.craback.Repository.UserRepository;
import com.example.craback.models.Project;
import com.example.craback.models.User;
import com.example.craback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Project addUsersToProject(List<Long> ids, Project project) {
        for (Long uId : ids){
            User user = findUserById(uId);
            if (user != null){
                user.addProject(project);
                userRepository.save(user);
            }
        }
        return project;
    }

    @Override
    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
