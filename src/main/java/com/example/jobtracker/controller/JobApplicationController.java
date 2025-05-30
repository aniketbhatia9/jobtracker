package com.example.jobtracker.controller;

import com.example.jobtracker.model.JobApplication;
import com.example.jobtracker.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return service.save(job);
    }

    @DeleteMapping // Handle Delete Requests
    public ResponseEntity<Void> deleteJob(@PathVariable Long id){
        // pathvariable extracts id from url path
        service.deleteById(id);
        return ResponseEntity.noContent().build();
        // response entity gives better control of http response
    }



}
