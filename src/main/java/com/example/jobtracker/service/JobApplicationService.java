package com.example.jobtracker.service;

import com.example.jobtracker.model.JobApplication;
import com.example.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // service means our business logic is written in this class
public class JobApplicationService {
    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository){
        this.repository = repository; // using the repository class so that our business logic so should remain clean with our repository interface.
    }

    public JobApplication save(JobApplication job){
        return repository.save(job);
    }

    public List<JobApplication> findAll(){
        return repository.findAll();
    }

    public Optional<JobApplication> findById(Long id){ // Optional to handle null values
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
