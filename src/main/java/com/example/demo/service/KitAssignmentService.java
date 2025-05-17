package com.example.demo.service;

import com.example.demo.dto.KitAssignmentDTO;
import com.example.demo.model.KitAssignment;
import com.example.demo.model.KitStatus;
import com.example.demo.repository.KitAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Builder
@Service
public class KitAssignmentService {

    @Autowired
    private KitAssignmentRepository kitAssignmentRepository;

    public KitAssignment assignKit(KitAssignmentDTO dto) {
        KitAssignment assignment = KitAssignment.builder()
                .assignmentId(UUID.randomUUID().toString())
                .userName(dto.getUserName())
                .kitId(dto.getKitId())
                .status(dto.getStatus())
                .requestDate(dto.getStatus() == KitStatus.REQUESTED ? LocalDate.now() : null)
                .build();

        return kitAssignmentRepository.save(assignment);
    }

    public List<KitAssignment> getAllIssuedKits() {
        return kitAssignmentRepository.findByStatus(KitStatus.ISSUED);
    }

    public List<KitAssignment> getAllRequestedKits() {
        return kitAssignmentRepository.findByStatus(KitStatus.REQUESTED);
    }

    public List<KitAssignment> getAllAssignments() {
        return kitAssignmentRepository.findAll();
    }
}
