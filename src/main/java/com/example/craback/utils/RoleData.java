package com.example.craback.utils;

import com.example.craback.models.ERole;
import com.example.craback.models.Role;
import lombok.Data;

import java.util.Set;

@Data
public class RoleData {

    private Set<Role> roles;
}
