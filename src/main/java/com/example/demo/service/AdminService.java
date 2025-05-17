package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String signup(AdminSignupDTO dto) {
        Optional<Admin> existing = adminRepository.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Admin already exists with this email");
        }

        Admin admin = Admin.builder()
                .name(dto.getName())
                .mobileNumber(dto.getMobileNumber())
                .DOB(dto.getDOB())
                .aadharCard(dto.getAadharCard())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        adminRepository.save(admin);
        return jwtUtil.generateToken(admin.getEmail());
    }

    public String login(AuthRequest authRequest) {
        Admin admin = adminRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(authRequest.getPassword(), admin.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(admin.getEmail());
    }
}
