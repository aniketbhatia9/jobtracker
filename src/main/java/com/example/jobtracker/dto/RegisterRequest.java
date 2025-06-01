package com.example.jobtracker.dto; // Data Transfer Object

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
