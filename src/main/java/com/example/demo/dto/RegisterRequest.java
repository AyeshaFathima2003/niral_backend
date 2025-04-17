package com.example.demo.dto;

import com.example.demo.model.Role;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    
    @NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;
    
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    
    private String email;  // Optional
    
    @NotBlank(message = "Aadhaar number is required")
    private String aadhaarNumber;

    @NotBlank(message = "Address line 1 is required")
    private String addressLine1;
    
    private String addressLine2;  // Optional
    private String landmark;  // Optional
    
    @NotBlank(message = "City is required")
    private String city;
    
    @NotBlank(message = "State is required")
    private String state;
    
    @NotBlank(message = "Pincode is required")
    private String pincode;
    
    @NotNull(message = "Role is required")
    private Role role;   // USER or ADMIN
    
    @NotBlank(message = "Password is required")
    private String password;
}
