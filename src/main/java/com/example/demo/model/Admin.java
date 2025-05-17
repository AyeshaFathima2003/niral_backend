package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {

    @Id
    private String adminId;
    
    private String name;           // Full name of the admin
    private String mobileNumber;   // Mobile number
    private String DOB;            // Optional - Date of Birth
    private String aadharCard;     // Aadhar card number

    private String username;       // Chosen username
    private String email;          // Email ID
    private String password;       // Encrypted password
}
