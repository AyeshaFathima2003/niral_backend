package com.example.demo.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    private String phoneNumber;   // Login with phone number
    private String password;
}

