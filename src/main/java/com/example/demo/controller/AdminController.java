package com.example.demo.controller;

import com.example.demo.dto.KitRequest;
import com.example.demo.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/register-kit")
    public ResponseEntity<?> registerKitForUser(@RequestBody KitRequest request) {
        return adminService.registerKit(request);
    }

    @GetMapping("/track-kit/{kitId}")
    public ResponseEntity<?> trackKit(@PathVariable String kitId) {
        return adminService.trackKit(kitId);
    }
}
