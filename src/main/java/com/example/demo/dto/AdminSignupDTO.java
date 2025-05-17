package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminSignupDTO {
    private String name;           // Admin's full name
    private String mobileNumber;   // Mobile number
    private String DOB;            // Optional - Date of Birth
    private String aadharCard;     // Aadhar card number
    private String username;       // Chosen username
    private String email;          // Email ID
    private String password;       // Plain password (to be encrypted)
}
