package com.example.demo.service;

import com.example.demo.model.Kit;
import com.example.demo.repository.KitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KitService {

    private final KitRepository kitRepository;

    /*public ResponseEntity<?> trackKit(String kitId) {
        return kitRepository.findById(kitId)
                .map(kit -> ResponseEntity.ok().body(kit)) // Ensuring ResponseEntity<Kit>
                .orElseGet(() -> ResponseEntity.badRequest().body("Kit not found!")); // Matching ResponseEntity<?> type
    }*/
    
    public ResponseEntity<?> getUserKitStatus(String userId) {
        List<Kit> kits = kitRepository.findByUserId(userId);
        if (kits.isEmpty()) {
            return ResponseEntity.badRequest().body("No kits found for this user!");
        }
        return ResponseEntity.ok(kits);
    }
}
