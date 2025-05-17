package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/admin")
public class AdminAuthController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody AdminSignupDTO dto) {
        try {
            String token = adminService.signup(dto);
            return new AuthResponse(token);
        } catch (Exception e) {
            e.printStackTrace(); // 👈 will print exact error
            throw new RuntimeException("Signup failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        try {
            String token = adminService.login(authRequest);
            return new AuthResponse(token);
        } catch (Exception e) {
            e.printStackTrace(); // 👈 will print exact error
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/logout")
    public String logout() {
        // No real server-side logic unless you're tracking sessions or blacklisting
        return "Logout successful. Please delete token from client.";
    }
}