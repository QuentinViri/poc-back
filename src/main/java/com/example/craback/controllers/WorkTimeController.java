package com.example.craback.controllers;

import com.example.craback.Repository.WorkTimeRepository;
import com.example.craback.models.Project;
import com.example.craback.models.User;
import com.example.craback.models.WorkTime;
import com.example.craback.service.ProjectService;
import com.example.craback.service.UserService;
import com.example.craback.service.WorkTimeService;
import com.example.craback.utils.WorkTimeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class WorkTimeController {

    @Autowired
    private WorkTimeService workTimeService;

    @Autowired
    private WorkTimeRepository workTimeRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @PostMapping("/users/{idUser}/project/{idProject}/worktimes")
    WorkTime addWorkTimesByUserByProject(@PathVariable("idUser") Long idUser,@PathVariable("idProject") Long idProject,@Valid @RequestBody WorkTimeData worktimedata) {
        WorkTime worktime = new WorkTime();
        User user = userService.findUserById(idUser);
        Project project = projectService.findProjectById(idProject);

        worktime.setDuration(worktimedata.getDuration());
        worktime.setDate(null);
        worktime.setProject(project);
        worktime.setUser(user);
        return workTimeService.createWorkTime(worktime);
    }

    @DeleteMapping("worktimes/{id}")
    public ResponseEntity<HttpStatus> deleteWorkTimes(@PathVariable("id")Long id){
        try{
            workTimeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/worktimes/{id}")
    public ResponseEntity<WorkTime> updateWorkTimes(@PathVariable("id") Long id,@RequestBody WorkTime workTime){
        Optional<WorkTime> workTimeData = workTimeRepository.findById(id);
        if(workTimeData.isPresent()){
            WorkTime _workTime = workTimeData.get();
            _workTime.setDate(workTime.getDate());
            _workTime.setDuration(workTime.getDuration());
            return new ResponseEntity<>(workTimeRepository.save(_workTime),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{idUser}/projects/{idProject}/worktimes")
    List<WorkTime> findAllWorkTimesByUserByProject(@PathVariable("idUser") Long idUser, @PathVariable("idProject") Long idProject){

        User user = userService.findUserById(idUser);
        Project project = projectService.findProjectById(idProject);

        List<WorkTime> project_workTimes = new ArrayList<WorkTime>();
        Set<WorkTime> user_workTimes = user.getWorkTimes();
        for(WorkTime wt : user_workTimes) {
            if(wt.getProject()==project) {
                project_workTimes.add(wt);
            }
        }

        return project_workTimes;
    }


}
