package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "kits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kit {

    @Id
    private String id;

    private String userId;   // User who registered the kit
    private String adminId;  // Admin who assisted in registration

    private LocalDate registrationDate;
    private LocalDate dispatchDate; // Set when kit is dispatched

    private KitStatus status; // PENDING, APPROVED, DISPATCHED, RETURNED, REJECTED
}
