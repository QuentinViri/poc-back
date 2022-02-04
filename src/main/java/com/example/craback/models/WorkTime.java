package com.example.craback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
public class WorkTime {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    private Long duration;

    @ManyToOne
    @JsonIgnoreProperties("users")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Project project;

    @ManyToOne
    @JsonIgnoreProperties ({"password", "roles", "workTimes","projects"})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;
}
