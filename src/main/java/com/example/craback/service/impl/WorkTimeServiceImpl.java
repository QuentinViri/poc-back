package com.example.craback.service.impl;

import com.example.craback.Repository.WorkTimeRepository;
import com.example.craback.models.WorkTime;
import com.example.craback.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeServiceImpl implements WorkTimeService {

    @Autowired
    private WorkTimeRepository workTimeRepository;


    @Override
    public List<WorkTime> findAllWorkTimes() {
        return this.workTimeRepository.findAll();
    }

    @Override
    public WorkTime createWorkTime(WorkTime worktime) {
        return workTimeRepository.save(worktime);
    }
}
