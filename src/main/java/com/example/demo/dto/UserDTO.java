package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String name;
    private String mobileNumber;
    private String emailId;
    private String aadharCard;
    private String address;
    private String district;
    private String purpose;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
}
