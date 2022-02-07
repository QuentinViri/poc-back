package com.example.craback.service.impl;

import com.example.craback.Repository.UserRepository;
import com.example.craback.models.Project;
import com.example.craback.models.Role;
import com.example.craback.models.User;
import com.example.craback.service.UserService;
import com.example.craback.utils.Listids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Project addUsersToProject(Listids ids, Project project) {
        for (Long uId : ids.getIds()){
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

    @Override
    public User changeRoleUser(Long id, Set<Role> roles){

        User user = findUserById(id);
        user.setRoles(roles);
        return user;
    }


}
