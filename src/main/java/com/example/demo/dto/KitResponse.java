package com.example.demo.dto;

import com.example.demo.model.KitStatus;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KitResponse {
    private String kitId;
    private String userId;
    private String adminId;
    private LocalDate registrationDate;
    private LocalDate dispatchDate;
    private KitStatus status;  // PENDING, APPROVED, DISPATCHED, RETURNED, REJECTED
}
