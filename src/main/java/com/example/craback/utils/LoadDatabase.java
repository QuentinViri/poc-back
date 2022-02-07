package com.example.craback.utils;

import com.example.craback.Repository.ProjectRepository;
import com.example.craback.Repository.RoleRepository;
import com.example.craback.Repository.UserRepository;
import com.example.craback.Repository.WorkTimeRepository;
import com.example.craback.models.ERole;
import com.example.craback.models.Role;
import com.example.craback.models.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.loadtime.Options;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    @Profile("!test")
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   ProjectRepository projectRepository,
                                   RoleRepository roleRepository,
                                   WorkTimeRepository workTimeRepository) {

        return args -> {

            initRoles(roleRepository);
        };
    }

    private void initRoles(RoleRepository roleRepository) {

        Role role_user = new Role();
        role_user.setName(ERole.ROLE_USER);
        roleRepository.save(role_user);

        Role role_manager = new Role();
        role_manager.setName(ERole.ROLE_MANAGER);
        roleRepository.save(role_manager);

        Role role_admin = new Role();
        role_admin.setName(ERole.ROLE_ADMIN);
        roleRepository.save(role_admin);



    }

}
