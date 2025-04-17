package com.example.demo.controller;

import com.example.demo.service.KitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kits")
@RequiredArgsConstructor
public class KitController {

    private final KitService kitService;

    /*@GetMapping("/track/{kitId}")
    public ResponseEntity<?> trackKit(@PathVariable String kitId) {
        return kitService.trackKit(kitId);
    } */

    @GetMapping("/status/{userId}")
    public ResponseEntity<?> getUserKitStatus(@PathVariable String userId) {
        return kitService.getUserKitStatus(userId);
    }
}
