package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KitRequest {
    private String userId;   // User registering the kit
    private String adminId;  // Admin assisting (if applicable)
    private String kitName;  // Name of the kit
}
