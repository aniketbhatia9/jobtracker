package com.example.jobtracker.controller;

import com.example.jobtracker.model.JobApplication;
import com.example.jobtracker.repository.JobApplicationRepository;
import com.example.jobtracker.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.example.jobtracker.repository.JobApplicationRepository;

import java.util.List;

@RestController // Tells spring to expose this class as a REST API
@RequestMapping("/api/jobs") // Base path for all endpoints
public class JobApplicationController {
    private final JobApplicationService service;


    public JobApplicationController(JobApplicationService service){
        this.service = service;

    }

    // GET /api/jobs
    @GetMapping
    public List<JobApplication> getAllJobs(){
        return service.findAll();
    }

    // GET /api/jobs/{id}
    @GetMapping("/{id}") // Handle get requests
    public ResponseEntity<JobApplication> getJobById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Handle post requests
    public JobApplication createJob(@RequestBody JobApplication job){
        // request body maps incoming json to java object
        job.setEmailId(SecurityContextHolder.getContext().getAuthentication().getName());
        return service.save(job);
    }

    @DeleteMapping("/{id}") // Handle Delete Requests
    public ResponseEntity<Void> deleteJob(@PathVariable Long id){
        // pathvariable extracts id from url path
        service.deleteById(id);
        return ResponseEntity.noContent().build();
        // response entity gives better control of http response
    }

    @GetMapping("/userjobs")
    public List<JobApplication> getJobsForCurrentUser() {
        String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(emailId + " emailid");
        return service.findByEmailId(emailId);
    }




}
