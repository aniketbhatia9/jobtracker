package com.example.jobtracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity // Spring will turn it into a DB Table
public class JobApplication {
    @Id // id means primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String positionTitle;
    private String status;
    private LocalDate appliedDate;
    private String notes;

    // Constructors
    public JobApplication(){

    }

    //Getters and Setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getPositionTitle(){
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle){
        this.positionTitle = positionTitle;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LocalDate getAppliedDate(){
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate){
        this.appliedDate = appliedDate;
    }

    public String getNotes(){
        return notes;
    }

    public void setNotes(){
        this.notes = notes;
    }
}
