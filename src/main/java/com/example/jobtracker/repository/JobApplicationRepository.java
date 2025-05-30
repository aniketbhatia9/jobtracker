package com.example.jobtracker.repository;

import com.example.jobtracker.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
//extends JpaRepository<...>	Gives us all CRUD methods like findAll(), save(), findById(), deleteById()
//JobApplication	The entity class we're working with
//Long	The type of the primary key (id field)
}
