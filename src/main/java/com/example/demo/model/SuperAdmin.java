package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "superadmins")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuperAdmin {
    
    @Id
    private String id;

    private String username;
    private String password; // Hashed password for authentication
}
