package com.example.jobtracker.service;

import com.example.jobtracker.dto.AuthenticationResponse;
import com.example.jobtracker.dto.AuthenticationRequest;
import com.example.jobtracker.dto.RegisterRequest;
import com.example.jobtracker.model.Role;
import com.example.jobtracker.model.User;
import com.example.jobtracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public Map<String, String> register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        Map<String, String> response = new HashMap<>();
        response.put("success", "User registered successfully!");
        return response;
    }
    public AuthenticationResponse login(AuthenticationRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        var token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

}
