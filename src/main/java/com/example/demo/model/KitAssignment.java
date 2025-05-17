package com.example.demo.model;

import com.example.demo.model.KitStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "kit_assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KitAssignment {

    @Id
    private String assignmentId;

    private String userName;
    private String kitId;

    private KitStatus status; // ISSUED, RETURNED, REQUESTED
    private LocalDate requestDate; // Field to track when the kit was requested
}
