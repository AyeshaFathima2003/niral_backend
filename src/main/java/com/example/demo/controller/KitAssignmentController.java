package com.example.demo.controller;

import com.example.demo.model.KitAssignment;
import com.example.demo.service.KitAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/kits")
public class KitAssignmentController {

    @Autowired
    private KitAssignmentService kitAssignmentService;

    // Get all issued kits
    @GetMapping("/issued")
    public List<KitAssignment> getIssuedKits() {
        return kitAssignmentService.getAllIssuedKits();
    }

    // Get all requested kits
    @GetMapping("/requested")
    public List<KitAssignment> getRequestedKits() {
        return kitAssignmentService.getAllRequestedKits();
    }

    // Get all kit assignments
    @GetMapping("/all")
    public List<KitAssignment> getAllAssignments() {
        return kitAssignmentService.getAllAssignments();
    }
}
