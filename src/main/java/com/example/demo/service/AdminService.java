package com.example.demo.service;

import com.example.demo.dto.KitRequest;
import com.example.demo.model.Kit;
import com.example.demo.model.KitStatus;
import com.example.demo.repository.KitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final KitRepository kitRepository;

    public ResponseEntity<?> registerKit(KitRequest request) {
        Kit kit = Kit.builder()
                .userId(request.getUserId())
                .adminId(request.getAdminId())
                .registrationDate(LocalDate.now())
                .status(KitStatus.PENDING)
                .build();

        kitRepository.save(kit);
        return ResponseEntity.ok("Kit registered successfully!");
    }

    public ResponseEntity<?> trackKit(String kitId) {
        Optional<Kit> kit = kitRepository.findById(kitId);
        return kit.map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());

    }
}
