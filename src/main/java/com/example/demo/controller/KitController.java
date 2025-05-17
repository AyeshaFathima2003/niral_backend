package com.example.demo.controller;

import com.example.demo.dto.KitDTO;
import com.example.demo.model.Kit;
import com.example.demo.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/kits")
public class KitController {

    @Autowired
    private KitService kitService;

    @PostMapping("/add")
    public Kit addKit(@RequestBody KitDTO kitDTO) {
        return kitService.addKit(kitDTO);
    }
}
