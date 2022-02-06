package com.example.craback.service;

import com.example.craback.models.Project;
import com.example.craback.models.Role;
import com.example.craback.models.User;
import com.example.craback.utils.Listids;
import com.example.craback.utils.RoleData;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    public List<User> findAllUsers();
    Project addUsersToProject(Listids ids, Project project);

    public User findUserById(Long id);
    public User changeRoleUser(Long id, Set<Role> roles);

}
