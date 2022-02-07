package com.example.craback.service;

import com.example.craback.models.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkTimeService  {
    public List<WorkTime> findAllWorkTimes();
    public WorkTime createWorkTime(WorkTime worktime);
}
