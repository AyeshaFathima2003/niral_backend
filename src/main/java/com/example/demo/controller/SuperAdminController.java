package com.example.demo.controller;

import com.example.demo.service.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superadmin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PostMapping("/approve/{kitId}")
    public ResponseEntity<?> approveKit(@PathVariable String kitId) {
        return superAdminService.approveKit(kitId);
    }

    @PostMapping("/reject/{kitId}")
    public ResponseEntity<?> rejectKit(@PathVariable String kitId) {
        return superAdminService.rejectKit(kitId);
    }
}
