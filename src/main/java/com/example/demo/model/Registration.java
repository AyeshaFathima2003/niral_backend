package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "registrations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registration {

    @Id
    private String id;

    private String name;
    private String mobileNumber;
    private String emailId;
    private String aadharId;
    private String address;
    private String district;
    private String purposeOfBorewell;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String locationType;

    private String registeredByAdminId; // To track which admin registered the user
}
