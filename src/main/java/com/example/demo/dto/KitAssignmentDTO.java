package com.example.demo.dto;

import com.example.demo.model.KitStatus;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KitAssignmentDTO {
    private String userName;
    private String kitId;
    private KitStatus status;
    private LocalDate requestDate;
}