package com.example.craback.controllers;

import com.example.craback.Repository.UserRepository;
import com.example.craback.models.*;
import com.example.craback.service.ProjectService;
import com.example.craback.service.UserService;
import com.example.craback.service.WorkTimeService;
import com.example.craback.utils.RoleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

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

    @PutMapping("/users/{id}/roles")
    User changeUserRole(@PathVariable("id") Long id, @RequestBody Set<Role> roles) {
        User user = userService.changeRoleUser(id,roles);
        return user;
//       Optional<User> userData= userRepository.findById(id);
//       if (userData.isPresent()){
//           User _user = userData.get();
//           _user.setRoles((Set<Role>) roles);
//           return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//       }else{
//           return   new ResponseEntity<>(HttpStatus.NOT_FOUND);
//       }

    }

    @GetMapping("/users/{id}/worktimes")
    Set<WorkTime> getWorkTimes(@PathVariable("id") Long idUser) {
        User user = userService.findUserById(idUser);
        return user.getWorkTimes();
    }







}
