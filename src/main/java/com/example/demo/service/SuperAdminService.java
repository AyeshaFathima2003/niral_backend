package com.example.demo.service;

import com.example.demo.model.Kit;
import com.example.demo.model.KitStatus;
import com.example.demo.repository.KitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuperAdminService {

    private final KitRepository kitRepository;

    public ResponseEntity<?> approveKit(String kitId) {
        Optional<Kit> kit = kitRepository.findById(kitId);
        
        if (kit.isPresent()) {
            kit.get().setStatus(KitStatus.APPROVED);
            kitRepository.save(kit.get());
            return ResponseEntity.ok("Kit approved successfully!");
        }
        return ResponseEntity.badRequest().body("Kit not found!");
    }

    public ResponseEntity<?> rejectKit(String kitId) {
        Optional<Kit> kit = kitRepository.findById(kitId);
        if (kit.isPresent()) {
            kit.get().setStatus(KitStatus.REJECTED);
            kitRepository.save(kit.get());
            return ResponseEntity.ok("Kit rejected successfully!");
        }
        return ResponseEntity.badRequest().body("Kit not found!");
    }
}
