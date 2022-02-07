package com.example.craback.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String description;

    @NotBlank
    private LocalDate date;

    @ToString.Exclude
    @ManyToMany(mappedBy="projects",fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"password","workTimes","projects","roles"})
    @EqualsAndHashCode.Exclude
    private Set<User> users;


    public Project() {

        this.users = new HashSet<>();

    }


}
